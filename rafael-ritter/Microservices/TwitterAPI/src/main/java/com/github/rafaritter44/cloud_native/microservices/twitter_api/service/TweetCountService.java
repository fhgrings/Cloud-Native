package com.github.rafaritter44.cloud_native.microservices.twitter_api.service;

import org.springframework.stereotype.Service;

import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

@Service
public class TweetCountService {
	
	public int getTweetCount(String user) throws TwitterException {
		return TwitterFactory.getSingleton().showUser(user).getStatusesCount();
	}
	
}
