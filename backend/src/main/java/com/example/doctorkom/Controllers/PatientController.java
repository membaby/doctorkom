package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Services.DashboardServices.PatientDashboardService;
import com.example.doctorkom.Services.UserProfileService.PatientProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    private final PatientProfileService patientProfileService;

    private final PatientDashboardService patientDashboardService;

    @Autowired
    public PatientController(PatientProfileService patientProfileService, PatientDashboardService patientDashboardService) {
        this.patientProfileService = patientProfileService;
        this.patientDashboardService = patientDashboardService;
    }

    @GetMapping("/profile")
    public PatientDTO getPatientProfile(@RequestParam String username) {
        return patientProfileService.getUserProfile(username);
    }

    @PutMapping("/profile")
    public void updatePatientProfile(@RequestBody PatientDTO patientDTO) {
        patientProfileService.updateUserProfile(patientDTO);
    }

    @GetMapping("/appointments/{userId}/{pageCount}")
    public Page<AppointmentDTO> getPatientAppointments(@PathVariable int userId, @PathVariable int pageCount) {
        return patientDashboardService.getPatientAppointments(userId, pageCount);
    }
}
