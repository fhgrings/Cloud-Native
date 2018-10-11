package com.github.fhgrings.springboot.exception;

public class InvalidUser extends RuntimeException {

    public InvalidUser(String message) {
        super(message);
    }
}
