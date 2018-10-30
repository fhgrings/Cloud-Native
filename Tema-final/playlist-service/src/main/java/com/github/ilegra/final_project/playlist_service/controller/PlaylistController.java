package com.github.ilegra.final_project.playlist_service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.github.ilegra.final_project.playlist_service.exception.InvalidIdException;
import com.github.ilegra.final_project.playlist_service.service.PlaylistService;
import com.google.gson.Gson;

@RestController
public class PlaylistController {
	private static final String DEFAULT_ERROR_MESAGE = "An unexpected error occured, please try again later";
	@Autowired
	private PlaylistService playlistService;

	@GetMapping("/ping")
	public String ping() {
		return "pong";
	}

	@GetMapping("/users/{userId}/playlist")
	public ResponseEntity<String> getUserPlaylists(@PathVariable("userId") int userId) {
		try {
			return new ResponseEntity<String>(new Gson().toJson(playlistService.getUserPlaylists(userId)),
					HttpStatus.OK);
		} catch (InvalidIdException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			return new ResponseEntity<String>(DEFAULT_ERROR_MESAGE, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/playlist/{playlistId}")
	public ResponseEntity<String> getPlaylist(@PathVariable("playlistId") int playlistId) {
		try {
			return new ResponseEntity<String>(new Gson().toJson(playlistService.getPlayList(playlistId)),
					HttpStatus.OK);
		} catch (InvalidIdException e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(DEFAULT_ERROR_MESAGE, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
