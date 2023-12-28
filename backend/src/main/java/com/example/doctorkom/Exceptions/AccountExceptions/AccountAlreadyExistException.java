package com.example.doctorkom.Exceptions.AccountExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistException extends DefaultException {
    public AccountAlreadyExistException(){
        super("Account already exist", HttpStatus.NOT_FOUND);
    }
}
