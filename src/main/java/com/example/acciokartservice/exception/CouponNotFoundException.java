package com.example.acciokartservice.exception;

public class CouponNotFoundException extends RuntimeException{

    public CouponNotFoundException(String message){
        super(message);
    }
}
