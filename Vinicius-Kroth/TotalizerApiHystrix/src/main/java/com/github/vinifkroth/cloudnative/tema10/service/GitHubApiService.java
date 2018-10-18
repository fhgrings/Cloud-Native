package com.github.vinifkroth.cloudnative.tema10.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema10.config.AppConfig;
import com.github.vinifkroth.cloudnative.tema10.exception.InvalidUsernameException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
@Service
public class GitHubApiService {
	private static final String URI = "http://172.18.0.22:8081";
	private static final ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	@HystrixCommand(fallbackMethod = "gitHubFallback")
	public String getUserRepositories(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = (RestTemplate) appContext.getBean("restTemplate");
		try {
			return restTemplate.getForEntity(URI + "/github/api/" + username, String.class).getBody();
		} catch (Exception e) {
			throw new InvalidUsernameException("The given username does not exist in github's database");
		}
	}

	public String gitHubFallback(String username) {
		return "The github service is currently unavailable or the given username does not exist, please try again.";
	}
}
