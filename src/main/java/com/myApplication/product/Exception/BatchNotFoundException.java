package com.myApplication.product.Exception;

public class BatchNotFoundException extends RuntimeException{

    public BatchNotFoundException(String msg){
        super(msg);
    }
}
