package com.example.doctorkom.Exceptions.MedicalNoteExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class MedicalNoteNotFoundException extends DefaultException {
    public MedicalNoteNotFoundException() {
        super("Medical Note not found", HttpStatus.NOT_FOUND);
    }
}
