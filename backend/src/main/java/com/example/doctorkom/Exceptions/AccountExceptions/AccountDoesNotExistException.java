package com.example.doctorkom.Exceptions.AccountExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountDoesNotExistException extends DefaultException {
    public AccountDoesNotExistException(){
        super("Account does not exist", HttpStatus.NOT_FOUND);
    }
}
