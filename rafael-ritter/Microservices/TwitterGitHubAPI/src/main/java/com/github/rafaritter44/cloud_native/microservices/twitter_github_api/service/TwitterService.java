package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.exception.UserNotFoundException;

@Service
public class TwitterService {

	public int getTweetCount(String username) throws UserNotFoundException, RestClientException {
		RestTemplate restTemplate = new RestTemplate();
		try {
			return restTemplate.getForObject("http://localhost:8081/" + username, Integer.class);
		} catch(RestClientException exception) {
			throw new UserNotFoundException(restTemplate.getForObject(
					"http://localhost:8081/" + username, String.class));
		}
	}
	
}
