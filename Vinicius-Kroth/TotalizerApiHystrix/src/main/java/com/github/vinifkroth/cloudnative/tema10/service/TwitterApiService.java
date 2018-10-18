package com.github.vinifkroth.cloudnative.tema10.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.github.vinifkroth.cloudnative.tema10.config.AppConfig;
import com.github.vinifkroth.cloudnative.tema10.exception.InvalidUsernameException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

@Service
public class TwitterApiService {
	private static final String uri = "http://172.18.0.23:8081";
	private static final ApplicationContext appContext = new AnnotationConfigApplicationContext(AppConfig.class);

	@HystrixProperty(name="hystrix.command.default.execution.timeout.enabled", value= "true")
	@HystrixCommand(fallbackMethod = "twitterFallback")
	public String getTweetsTotalCount(String username) throws InvalidUsernameException {
		RestTemplate restTemplate = (RestTemplate) appContext.getBean("restTemplate");
		try {
			return restTemplate.getForEntity(uri + "/twitter/api/" + username, String.class).getBody();
		} catch (RestClientException e) {
			e.printStackTrace();
			throw new InvalidUsernameException("The given username does not exist in twitter's database");
		}
	}

	public String twitterFallback(String username) {
		return "The twitter service is currently unavailable or the given username does not exist, please try again.";
	}
}
