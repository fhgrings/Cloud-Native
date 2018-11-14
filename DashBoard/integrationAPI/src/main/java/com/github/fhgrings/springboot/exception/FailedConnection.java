package com.github.fhgrings.springboot.exception;

public class FailedConnection extends RuntimeException{
    public FailedConnection(String message) {
        super(message);
    }

}
