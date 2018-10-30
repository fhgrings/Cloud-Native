package com.github.ilegra.final_project.song_service.command;

import com.github.ilegra.final_project.song_service.database.ConnectionFactory;
import com.github.ilegra.final_project.song_service.model.Song;
import com.google.gson.Gson;
import com.netflix.hystrix.HystrixCommand;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SearchByPlaylistCommand extends HystrixCommand<String> {

    private int id_song;

    public SearchByPlaylistCommand(Setter config, int id_song) {
        super(config);
        this.id_song = id_song;
    }

    @Override
    protected String run() throws Exception {

        StringBuffer sb = new StringBuffer();
        try (Connection con = ConnectionFactory.getConnection(); PreparedStatement stmt = con.prepareStatement("SELECT * FROM song WHERE id = " + id_song )) {
            ResultSet rs = stmt.executeQuery();
            Song song = new Song();

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String singer = rs.getString("singer");
                String album = rs.getString("album");

                song = new Song(id,name,album,singer);
            }

            Gson gson = new Gson();
            sb.append(gson.toJson(song));


        } catch (Exception exception) {
            throw exception;
        }
        return sb.toString();
    }


    @Override
    protected String getFallback() {
        return "Hello Failure !";
    }
}
