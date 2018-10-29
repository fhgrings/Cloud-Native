package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.config.AppConfig;
import com.github.rafaritter44.cloud_native.microservices.twitter_github_api.exception.UserNotFoundException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class TwitterService {
	
	private final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);
	private final String URL = "http://172.17.0.2:8081/";

	@HystrixCommand(fallbackMethod = "defaultTweetCount")
	public int getTweetCount(String username) throws UserNotFoundException, RestClientException {
		RestTemplate restTemplate = CONTEXT.getBean(RestTemplate.class);
		try {
			return restTemplate.getForObject(URL + username, Integer.class);
		} catch(RestClientException exception) {
			throw new UserNotFoundException(restTemplate.getForObject(
					URL + username, String.class));
		}
	}
	
	public int defaultTweetCount(String username) {
		return 0;
	}
	
}
