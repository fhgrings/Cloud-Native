package com.github.rafaritter44.cloud_native.microservices.github_api.exception;

public class UserNotFoundException extends Exception {
	public UserNotFoundException(String message) {
		super(message);
	}
}
