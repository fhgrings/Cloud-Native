package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema7.config.AppConfig;
import com.github.vinifkroth.cloudnative.tema7.dto.TotalRepositoriesDto;
import com.github.vinifkroth.cloudnative.tema7.exception.InvalidUsernameException;
import com.google.gson.Gson;

@Service
public class GitHubApiService {
	private static final String URL = "https://api.github.com/search/repositories?q=user:";
	private static final ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	public TotalRepositoriesDto getAllRepos(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = (RestTemplate) appContext.getBean("restTemplate");
		Gson gson = (Gson) appContext.getBean("gson");
		try {
			return gson.fromJson(restTemplate.getForObject(URL + username, String.class), TotalRepositoriesDto.class);
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new InvalidUsernameException("The given username does not match any GitHub users.");
		}

	}

}
