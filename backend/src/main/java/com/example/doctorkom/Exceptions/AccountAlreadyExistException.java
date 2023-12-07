package com.example.doctorkom.Exceptions;

public class AccountAlreadyExistException extends RuntimeException {
    public AccountAlreadyExistException(String message){
        super(message);
    }

}
