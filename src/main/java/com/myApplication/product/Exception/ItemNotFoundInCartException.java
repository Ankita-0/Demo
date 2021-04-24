package com.myApplication.product.Exception;

public class ItemNotFoundInCartException extends RuntimeException{

    public ItemNotFoundInCartException(String msg){
        super(msg);
    }
}
