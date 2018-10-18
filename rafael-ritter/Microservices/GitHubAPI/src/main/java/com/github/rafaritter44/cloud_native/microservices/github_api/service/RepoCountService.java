package com.github.rafaritter44.cloud_native.microservices.github_api.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.rafaritter44.cloud_native.microservices.github_api.config.AppConfig;
import com.github.rafaritter44.cloud_native.microservices.github_api.dto.GitHubUserDTO;
import com.github.rafaritter44.cloud_native.microservices.github_api.exception.UserNotFoundException;

@Service
public class RepoCountService {

	private final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);
	private final String URI = "https://api.github.com/users/";
	
    public int getRepoCount(String username) throws UserNotFoundException {
        try {
        	return CONTEXT.getBean(RestTemplate.class)
        			.getForObject(URI + username, GitHubUserDTO.class)
        			.getRepoCount();
        } catch(RestClientException exception) {
        	throw new UserNotFoundException("ERROR: user not found");
        }
    }

}
