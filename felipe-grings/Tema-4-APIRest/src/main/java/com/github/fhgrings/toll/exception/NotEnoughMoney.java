package com.github.fhgrings.toll.exception;

public class NotEnoughMoney extends RuntimeException{
    public NotEnoughMoney(String exceptionString) {
        super(exceptionString);
    }
}
