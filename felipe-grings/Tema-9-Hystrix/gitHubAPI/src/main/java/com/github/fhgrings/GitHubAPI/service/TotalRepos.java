package com.github.fhgrings.GitHubAPI.service;

import com.github.fhgrings.GitHubAPI.model.PublicRepos;
import org.springframework.web.client.RestTemplate;

public class TotalRepos {
    private RestTemplate restTemplate = new RestTemplate();
    final String URL = "https://api.github.com/users/";

    public int execute(String user) {

        PublicRepos publicRepos = restTemplate.getForObject(url + user,  PublicRepos.class);

        return publicRepos.getPublicRepos();
    }
}
