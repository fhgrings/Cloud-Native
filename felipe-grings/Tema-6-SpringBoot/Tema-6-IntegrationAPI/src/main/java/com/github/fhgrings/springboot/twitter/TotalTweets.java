package com.github.fhgrings.springboot.twitter;

import com.github.fhgrings.springboot.exception.InvalidUser;
import org.springframework.web.client.RestTemplate;

public class TotalTweets {

    private RestTemplate restTemplate = new RestTemplate();

    public int execute(String user) throws Exception {
        String url = "http://172.18.0.23:8080/tweet?user=";
        Integer publicRepos;

        try {
            publicRepos = restTemplate.getForObject(url + user, Integer.class);

        } catch (Exception e) {
            throw new InvalidUser("Erro");
        }
        return publicRepos;
    }

}
