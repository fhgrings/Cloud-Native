package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema7.dto.TotalRepositoriesDto;
import com.github.vinifkroth.cloudnative.tema7.exception.InvalidUsernameException;
import com.google.gson.Gson;

@Service
public class GitHubApiService {
	private static final String URL = "https://api.github.com/search/repositories?q=user:";

	public TotalRepositoriesDto getAllRepos(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = new RestTemplate();
		Gson gson = new Gson();
		String retorno;
		try {
			return gson.fromJson(restTemplate.getForObject(URL+username, String.class), TotalRepositoriesDto.class);
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new InvalidUsernameException("The given username does not match any GitHub users.");
		}
	  
	}

}
