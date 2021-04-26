package com.myApplication.product.Exception;

public class CartIsEmptyException extends RuntimeException {
    public CartIsEmptyException(String msg){
        super(msg);
    }
}
