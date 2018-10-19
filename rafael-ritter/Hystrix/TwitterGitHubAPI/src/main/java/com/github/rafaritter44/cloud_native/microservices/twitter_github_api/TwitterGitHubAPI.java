package com.github.rafaritter44.cloud_native.microservices.twitter_github_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class TwitterGitHubAPI {
	
	public static void main(String[] args) {
		SpringApplication.run(TwitterGitHubAPI.class, args);
	}
	
}
