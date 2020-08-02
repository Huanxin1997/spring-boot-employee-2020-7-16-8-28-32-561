package com.thoughtworks.springbootemployee.handler;

import com.thoughtworks.springbootemployee.exceptioin.IllegalException;
import com.thoughtworks.springbootemployee.exceptioin.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHanlder {

    @ExceptionHandler(NotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String notFound(NotFoundException notFoundException) {
        return notFoundException.getMessage();
    }

    @ExceptionHandler(IllegalException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public String illegalOperate(IllegalException illegalException) {
        return illegalException.getMessage();
    }

}
