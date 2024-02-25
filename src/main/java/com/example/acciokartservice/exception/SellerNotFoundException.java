package com.example.acciokartservice.exception;

import com.example.acciokartservice.repository.SellerRepository;

public class SellerNotFoundException extends RuntimeException{

    public SellerNotFoundException(String message){
        super(message);
    }
}
