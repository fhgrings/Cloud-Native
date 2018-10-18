package com.github.vinifkroth.cloudnative.tema10.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.vinifkroth.cloudnative.tema10.exception.InvalidUsernameException;
import com.github.vinifkroth.cloudnative.tema10.service.GitHubApiService;
import com.github.vinifkroth.cloudnative.tema10.service.TwitterApiService;

@EnableCircuitBreaker
@RequestMapping("/api")
@RestController
public class ApiController {

	@Autowired
	private TwitterApiService twitterApiService;
	@Autowired
	private GitHubApiService gitHubApiService;

	@GetMapping("/ping")
	@ResponseBody
	public String ping() {
		return "pong";
	}

	@RequestMapping("")
	@ResponseBody
	public ResponseEntity<String> getUserInfo(@RequestParam(value = "twitterName") String twitterUsername,
			@RequestParam(value = "githubName") String githubUsername) {
		StringBuilder str = new StringBuilder();
		try {
			str.append(twitterApiService.getTweetsTotalCount(twitterUsername)).append("\n\n");
		} catch (InvalidUsernameException e) {
			str.append(e.getMessage());
		}

		try {
			str.append(gitHubApiService.getUserRepositories(githubUsername));
		} catch (InvalidUsernameException e) {
			str.append(e.getMessage());
		}

		return new ResponseEntity<>(str.toString(), HttpStatus.OK);
	}
}
