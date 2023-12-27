package com.example.doctorkom.Exceptions.DoctorExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class DoctorNotFoundException extends DefaultException {
    public DoctorNotFoundException(){
        super("Doctor not found", HttpStatus.NOT_FOUND);
    }
}
