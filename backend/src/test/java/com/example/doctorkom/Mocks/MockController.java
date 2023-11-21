package com.example.doctorkom.Mocks;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {
    @PostMapping("/registration/patient")
    public String patientRegistration() {
        return "Patient successfully registered";
    }

    @PostMapping("/registration/doctor")
    public String doctorRegistration() {
        return "Doctor successfully registered";
    }

    @PostMapping("/login/patient")
    public String patientLogin() {
        return "Patient successfully logged in";
    }

    @PostMapping("/login/doctor")
    public String doctorLogin() {
        return "Doctor successfully logged in";
    }
}