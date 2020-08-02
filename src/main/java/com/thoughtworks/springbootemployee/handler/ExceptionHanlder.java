package com.thoughtworks.springbootemployee.handler;

import com.thoughtworks.springbootemployee.exceptioin.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class ExceptionHanlder {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NotFoundException notFoundException) {
        return "Not found this data";
    }

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String badRequest(NotFoundException notFoundException) {
        return "Bad Request, please check your params";
    }
}
