package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema7.config.AppConfig;
import com.github.vinifkroth.cloudnative.tema7.exception.InvalidUsernameException;

@Service
public class GitHubApiService {
	private static final String uri = "http://172.18.0.22:8081";
	private static final ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	public String getUserRepositories(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = (RestTemplate) appContext.getBean("restTemplate");
		try {
			return restTemplate.getForEntity(uri + "/github/api/" + username, String.class).getBody();
		} catch (Exception e) {
			throw new InvalidUsernameException("The given username does not exist in github's database");
		}
	}
}
