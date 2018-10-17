package com.github.vinifkroth.cloudnative.tema7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.github.vinifkroth.cloudnative.tema7.dto.TotalRepositoriesDto;
import com.github.vinifkroth.cloudnative.tema7.exception.InvalidUsernameException;
import com.github.vinifkroth.cloudnative.tema7.service.GitHubApiService;

@RequestMapping("/api")
@RestController
public class GitHubController {

	@Autowired
	private GitHubApiService apiService;

	@GetMapping("/ping")
	@ResponseBody
	public String ping() {
		return "pong";
	}
	@RequestMapping("/{username}")
	@ResponseBody
	public ResponseEntity<String> getUserRepoTotal(@PathVariable(value = "username") String username) {
		try {
			return new ResponseEntity<>(apiService.getAllRepos(username).toString(), HttpStatus.OK);
		} catch (InvalidUsernameException e) {
			throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, e.toString());
		}
	}
}
