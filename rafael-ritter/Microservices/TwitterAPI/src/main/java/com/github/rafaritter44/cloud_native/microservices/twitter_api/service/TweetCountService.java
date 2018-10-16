package com.github.rafaritter44.cloud_native.microservices.twitter_api.service;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Service;

import com.github.rafaritter44.cloud_native.microservices.twitter_api.config.AppConfig;

import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TweetCountService {
	
	private final ApplicationContext CONTEXT = new AnnotationConfigApplicationContext(AppConfig.class);
	
	public int getTweetCount(String username) throws TwitterException {
		return CONTEXT.getBean(Twitter.class).showUser(username).getStatusesCount();
	}
	
}
