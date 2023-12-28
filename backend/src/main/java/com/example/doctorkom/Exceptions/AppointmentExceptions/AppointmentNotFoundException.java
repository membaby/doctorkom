package com.example.doctorkom.Exceptions.AppointmentExceptions;

import com.example.doctorkom.Exceptions.DefaultException;
import org.springframework.http.HttpStatus;

public class AppointmentNotFoundException extends DefaultException {
    public AppointmentNotFoundException() {
        super("Appointment not found", HttpStatus.NOT_FOUND);
    }
}
