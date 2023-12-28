package com.example.doctorkom.Exceptions.PatientExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class PatientNotFoundException extends DefaultException {
    public PatientNotFoundException(){
        super("Patient not found", HttpStatus.NOT_FOUND);
    }
}
