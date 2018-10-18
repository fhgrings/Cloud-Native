package com.github.fhgrings.springboot.twitter;

import com.github.fhgrings.springboot.exception.FailedConnection;
import org.springframework.web.client.RestTemplate;

public class TotalTweets {

    private RestTemplate restTemplate = new RestTemplate();

    public int execute(String user) throws FailedConnection {
        String url = "http://172.18.0.23:8080/tweet?user=";

        try {
            return restTemplate.getForObject(url + user, Integer.class);

        } catch (Exception e) {
            throw new FailedConnection("Error: Connection Failed");
        }
    }

}
