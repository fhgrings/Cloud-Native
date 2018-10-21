package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.model;

public class TwitterUser {
	
	private String username;
	private int tweetCount;
	
	public TwitterUser(String username, int tweetCount) {
		this.username = username;
		this.tweetCount = tweetCount;
	}
	
	public String getUsername() { return username; }
	public int getTweetCount() { return tweetCount; }

}
