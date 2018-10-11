package com.github.fhgrings.springboot.github;

import com.github.fhgrings.springboot.exception.InvalidUser;
import org.springframework.web.client.RestTemplate;

public class TotalRepos {

    private RestTemplate restTemplate = new RestTemplate();

    public int execute(String user) throws Exception {
        String url = "http://172.18.0.25:8080/repos?user=";

        Integer publicRepos = restTemplate.getForObject(url + user, Integer.class);

        if(publicRepos == null)
            throw new InvalidUser("Error");

        return publicRepos;
    }
}
