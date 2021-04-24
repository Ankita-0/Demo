package com.myApplication.product.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ItemNotFoundInCartAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ItemNotFoundInCartException.class)
    public @ResponseBody String ItemNotFoundInCartHandler(ItemNotFoundInCartException e){
        return e.getMessage();
    }
}
