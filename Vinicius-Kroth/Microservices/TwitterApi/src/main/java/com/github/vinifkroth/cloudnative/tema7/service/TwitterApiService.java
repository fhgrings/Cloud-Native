package com.github.vinifkroth.cloudnative.tema7.service;

import org.springframework.stereotype.Service;

import com.github.vinifkroth.cloudnative.tema7.config.TwitterConfiguration;

import twitter4j.Twitter;
import twitter4j.TwitterException;

@Service
public class TwitterApiService {

	public int getTweetsTotalCount(String username) throws TwitterException {
		Twitter twitter = TwitterConfiguration.getTwitterInstance();
		return twitter.showUser(username).getStatusesCount();
	}
}
