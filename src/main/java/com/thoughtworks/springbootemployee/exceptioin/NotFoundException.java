package com.thoughtworks.springbootemployee.exceptioin;

public class NotFoundException extends Exception{
    @Override
    public String getMessage() {
        return "Not Found Exception";
    }
}
