package com.github.fhgrings.springboot.service;

import com.github.fhgrings.springboot.exception.FailedConnection;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TwitterService {

    private RestTemplate restTemplate = new RestTemplate();
    private final String URL = "http://172.18.0.23:8080/tweet?user=";


    @HystrixCommand(fallbackMethod = "defaultRepos", commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000"))
    public int execute(String user) throws FailedConnection {

        try {
            return restTemplate.getForObject(url + user, Integer.class);

        } catch (Exception e) {
            throw new FailedConnection("Error: Connection Failed");
        }
    }

    public int defaultRepos(String username) {
        return 0;
    }

}
