package com.example.doctorkom.Mocks;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MockController {
    @PostMapping("/registration/patient")
    public String patientRegistration() {
        return "Patient registered successfully";
    }

    @PostMapping("/registration/doctor")
    public String doctorRegistration() {
        return "Doctor registered successfully";
    }

    @PostMapping("/login")
    public String login() {
        return "Logged in successfully";
    }

    @PostMapping("/recover_password")
    public String recoverPassword() {
        return "Password recovered successfully";
    }
}