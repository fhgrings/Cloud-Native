package com.github.ilegra.final_project.playlist_service.command;

import com.github.ilegra.final_project.playlist_service.db.ConnectionFactory;
import com.github.ilegra.final_project.playlist_service.dto.PlaylistDTO;
import com.netflix.hystrix.HystrixCommand;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RetrieveUserPlaylistCommand extends HystrixCommand<List<PlaylistDTO>> {

	private int userId;

	public RetrieveUserPlaylistCommand(int userId, Setter setter) {
		super(setter);
		this.userId = userId;
	}

	@Override
	protected List<PlaylistDTO> run() throws Exception {
		List<PlaylistDTO> playlists = new ArrayList<PlaylistDTO>();
		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement statement = connection
						.prepareStatement("SELECT * FROM Playlists WHERE user_id = " + userId)) {
			ResultSet resultSet = statement.executeQuery();
			PlaylistDTO playlist;
			while (resultSet.next()) {
				playlist = new PlaylistDTO(resultSet.getInt("user_id"), resultSet.getInt("id"),
						resultSet.getString("name"));
				playlists.add(playlist);
			}
		} catch (Exception e) {
			throw e;
		}
		return playlists;
	}

	@Override
	protected List<PlaylistDTO> getFallback() {
		return new ArrayList<>();
	}
}