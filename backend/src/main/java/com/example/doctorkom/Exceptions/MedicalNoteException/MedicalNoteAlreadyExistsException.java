package com.example.doctorkom.Exceptions.MedicalNoteException;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class MedicalNoteAlreadyExistsException extends DefaultException {
    public MedicalNoteAlreadyExistsException() {
        super("Medical note already exists", HttpStatus.NOT_ACCEPTABLE);
    }
}
