package com.github.fhgrings.springboot.github;

import com.github.fhgrings.springboot.exception.FailedConnection;
import org.springframework.web.client.RestTemplate;

public class TotalRepos {

    private RestTemplate restTemplate = new RestTemplate();

    public int execute(String user) throws FailedConnection {
        String url = "http://172.18.0.25:8080/repos?user=";

        try {
        return restTemplate.getForObject(url + user, Integer.class);
        } catch (Exception e) {
            throw new FailedConnection("Error: Connection Failed");
        }

    }
}
