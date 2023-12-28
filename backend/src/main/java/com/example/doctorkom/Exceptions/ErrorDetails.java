package com.example.doctorkom.Exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Date;

@Data
@Builder
public class ErrorDetails {
    private HttpStatus status;
    private String message;
    private Date timestamp;
}
