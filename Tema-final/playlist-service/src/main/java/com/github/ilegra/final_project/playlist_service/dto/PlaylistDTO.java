package com.github.ilegra.final_project.playlist_service.dto;

public class PlaylistDTO {

    private int user_id;
    private int id;
    private String name;

    public PlaylistDTO(int user_id, int id, String name) {
        this.user_id = user_id;
        this.id = id;
        this.name = name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}