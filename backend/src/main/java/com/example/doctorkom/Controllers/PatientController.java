package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Services.UserProfileService.PatientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientProfileService patientProfileService;

    @Autowired
    public PatientController(PatientProfileService patientProfileService) {
        this.patientProfileService = patientProfileService;
    }

    @GetMapping("/profile")
    public PatientDTO getPatientProfile(@RequestParam String username) {
        return patientProfileService.getUserProfile(username);
    }

    @PutMapping("/profile")
    public void updatePatientProfile(@RequestBody PatientDTO patientDTO) {
        patientProfileService.updateUserProfile(patientDTO);
    }
}
