package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Services.UserProfileService.DoctorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorProfileService doctorProfileService;

    @Autowired
    public DoctorController(DoctorProfileService doctorProfileService) {
        this.doctorProfileService = doctorProfileService;
    }

    @GetMapping("/profile")
    public DoctorDTO getDoctorProfile(@RequestParam String username) {
        return doctorProfileService.getUserProfile(username);
    }

    @PutMapping("/profile")
    public void updateDoctorProfile(@RequestBody DoctorDTO doctorDTO) {
        doctorProfileService.updateUserProfile(doctorDTO);
    }
}
