package com.github.fhgrings.Hystrix;

import com.netflix.hystrix.HystrixCommand;
import org.springframework.web.client.RestTemplate;


public class CommandHelloWorld extends HystrixCommand<String> {
    private RestTemplate restTemplate = new RestTemplate();

    private String name;

    public CommandHelloWorld(Setter config, String name) {
        super(config);
        this.name = name;
    }

    @Override
    protected String run() {
        String url = "http://172.18.0.25:8080/repos?user=" + name;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    protected String getFallback() {
        return "Hello Failure !";
    }
}