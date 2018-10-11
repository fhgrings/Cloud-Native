package com.github.fhgrings.GitHubAPI.service;

import com.github.fhgrings.GitHubAPI.exception.InvalidUser;
import com.github.fhgrings.GitHubAPI.model.PublicRepos;
import org.springframework.web.client.RestTemplate;

public class TotalRepos {
    private RestTemplate restTemplate = new RestTemplate();

    public int execute(String user) throws InvalidUser {
        String url = "https://api.github.com/users/";

        PublicRepos publicRepos = restTemplate.getForObject(url + user,  PublicRepos.class);

        if(publicRepos.getPublicRepos() == null)
            throw new InvalidUser("Error");

        return publicRepos.getPublicRepos();
    }
}
