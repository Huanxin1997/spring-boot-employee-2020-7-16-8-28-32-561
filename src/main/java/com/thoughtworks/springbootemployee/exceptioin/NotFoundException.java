package com.thoughtworks.springbootemployee.exceptioin;

public class NotFoundException extends Exception{
    public NotFoundException(String message) {
        super(message);
    }
}
