package com.github.rafaritter44.cloud_native.microservices.twitter_github_api.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
	}
}
