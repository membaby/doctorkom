package com.example.doctorkom.Exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Getter
public abstract class DefaultException extends RuntimeException{
    private final ErrorDetails errorDetails;
    public DefaultException(String message, HttpStatus httpStatus){
        super(message);
        this.errorDetails = ErrorDetails.builder()
                .message(message)
                .status(httpStatus)
                .timestamp(new Date())
                .build();
    }
}
