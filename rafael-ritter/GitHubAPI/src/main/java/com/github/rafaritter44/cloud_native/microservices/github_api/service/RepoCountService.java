package com.github.rafaritter44.cloud_native.microservices.github_api.service;

import com.github.rafaritter44.cloud_native.microservices.github_api.dto.GitHubUserDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RepoCountService {

    public int getRepoCount(String user) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://api.github.com/users/" + user, GitHubUserDTO.class).getRepoCount();
    }

}
