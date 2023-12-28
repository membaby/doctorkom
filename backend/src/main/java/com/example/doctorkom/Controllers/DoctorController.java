package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Services.DashboardServices.DoctorDashboardService;
import com.example.doctorkom.Services.UserProfileService.DoctorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    private final DoctorProfileService doctorProfileService;

    private final DoctorDashboardService doctorDashboardService;

    @Autowired
    public DoctorController(DoctorProfileService doctorProfileService, DoctorDashboardService doctorDashboardService) {
        this.doctorProfileService = doctorProfileService;
        this.doctorDashboardService = doctorDashboardService;
    }

    @GetMapping("/profile")
    public DoctorDTO getDoctorProfile(@RequestParam String username) {
        return doctorProfileService.getUserProfile(username);
    }

    @PutMapping("/profile")
    public void updateDoctorProfile(@RequestBody DoctorDTO doctorDTO) {
        doctorProfileService.updateUserProfile(doctorDTO);
    }

    @GetMapping("/appointments/{doctorId}/{pageCount}")
    public Page<AppointmentDTO> getDoctorAppointments(@PathVariable int doctorId, @PathVariable int pageCount) {
        return doctorDashboardService.getDoctorAppointments(doctorId, pageCount);
    }
}
