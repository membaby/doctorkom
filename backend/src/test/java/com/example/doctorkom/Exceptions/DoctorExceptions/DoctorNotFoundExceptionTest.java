package com.example.doctorkom.Exceptions.DoctorExceptions;

import com.example.doctorkom.Exceptions.ErrorDetails;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
class DoctorNotFoundExceptionTest {
    @Test
    void testExceptionMessageAndHttpStatus() {
        DoctorNotFoundException exception = new DoctorNotFoundException();

        ErrorDetails errorDetails = ErrorDetails.builder().status(HttpStatus.NOT_FOUND).message("Doctor not found").timestamp(new Date()).build();

        assertEquals(errorDetails, exception.getErrorDetails());
        assertEquals(errorDetails.getTimestamp().getTime() / 10000, exception.getErrorDetails().getTimestamp().getTime() / 10000);
    }
}