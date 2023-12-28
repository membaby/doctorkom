package com.example.doctorkom.Exceptions.AccountExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountAlreadyExistsException extends DefaultException {
    public AccountAlreadyExistsException(){
        super("Account already exists", HttpStatus.NOT_ACCEPTABLE);
    }
}
