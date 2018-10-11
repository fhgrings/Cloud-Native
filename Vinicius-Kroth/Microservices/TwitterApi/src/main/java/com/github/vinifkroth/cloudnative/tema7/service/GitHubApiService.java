package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
@Service
public class GitHubApiService {

	public String getUserRepositories(String username) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity("http://172.18.0.22:8081/github/api/rafaritter44", String.class).getBody();
	}
}
