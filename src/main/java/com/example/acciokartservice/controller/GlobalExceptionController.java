package com.example.acciokartservice.controller;

import com.example.acciokartservice.dto.response.ExceptionResponse;
import com.example.acciokartservice.exception.CustomerNotFoundException;
import com.example.acciokartservice.exception.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionController {

    @ExceptionHandler(value = {CustomerNotFoundException.class,
            ProductNotFoundException.class})
    public ResponseEntity<ExceptionResponse> handleExceptions(RuntimeException e){
        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .message(e.getMessage())
                .statusCode(HttpStatus.BAD_REQUEST)
                .build();
        return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
