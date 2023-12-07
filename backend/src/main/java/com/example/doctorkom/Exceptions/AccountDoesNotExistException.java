package com.example.doctorkom.Exceptions;

public class AccountDoesNotExistException extends RuntimeException {
    public AccountDoesNotExistException(String message){
        super(message);
    }
}
