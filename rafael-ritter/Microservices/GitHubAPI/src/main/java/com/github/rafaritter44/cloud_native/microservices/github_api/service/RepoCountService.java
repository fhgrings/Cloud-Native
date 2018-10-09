package com.github.rafaritter44.cloud_native.microservices.github_api.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.rafaritter44.cloud_native.microservices.github_api.dto.GitHubUserDTO;
import com.github.rafaritter44.cloud_native.microservices.github_api.exception.UserNotFoundException;

@Service
public class RepoCountService {

    public int getRepoCount(String username) throws UserNotFoundException {
        RestTemplate restTemplate = new RestTemplate();
        try {
        	return restTemplate
        			.getForObject("https://api.github.com/users/" + username, GitHubUserDTO.class)
        			.getRepoCount();
        } catch(RestClientException exception) {
        	throw new UserNotFoundException("ERROR: user not found");
        }
    }

}
