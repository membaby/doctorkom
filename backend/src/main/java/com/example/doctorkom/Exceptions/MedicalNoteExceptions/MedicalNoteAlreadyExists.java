package com.example.doctorkom.Exceptions.MedicalNoteExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class MedicalNoteAlreadyExists extends DefaultException {
    public MedicalNoteAlreadyExists() {
        super("Medical Note already exists", HttpStatus.NOT_ACCEPTABLE);
    }
}
