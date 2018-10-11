package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema7.exception.InvalidUsernameException;

@Service
public class GitHubApiService {

	public String getUserRepositories(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForEntity("http://172.18.0.22:8081/github/api/" + username, String.class).getBody();
		} catch (Exception e) {
			throw new InvalidUsernameException("The given username does not exist in github's database");
		}
	}
}
