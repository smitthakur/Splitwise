package com.blackbucks.Splitwise.exceptions;

import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends Exception{
    @ExceptionHandler({ExecutionControl.UserException.class})
    ResponseEntity<String> handleUserException(ExecutionControl.UserException e){
        String message = e.getMessage();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler({Exception.class})
    ResponseEntity<String> handleAllException(Exception e){
        String message = e.getMessage();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(message);
    }
}