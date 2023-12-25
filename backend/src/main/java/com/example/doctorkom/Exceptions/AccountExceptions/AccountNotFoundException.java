package com.example.doctorkom.Exceptions.AccountExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends DefaultException {
    public AccountNotFoundException(){
        super("Account not found", HttpStatus.NOT_FOUND);
    }
}
