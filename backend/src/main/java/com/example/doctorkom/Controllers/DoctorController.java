package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Services.DashboardServices.DoctorDashboardService;
import com.example.doctorkom.Services.UserProfileService.DoctorProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //EX: /appointments?doctorId=1
    @GetMapping("/appointments")
    public List<AppointmentDTO> getDoctorAppointments(@RequestParam int doctorId) {
        return doctorDashboardService.getDoctorAppointments(doctorId);
    }

    //EX: /timeslots?doctorId=1
    @GetMapping("/timeslots")
    public List<TimeSlotDTO> getDoctorTimeSlots(@RequestParam int doctorId) {
        return doctorDashboardService.getDoctorTimeSlots(doctorId);
    }

    //EX: /clinics?doctorId=1
    @GetMapping("/clinics")
    public List<ClinicDTO> getDoctorClinics(@RequestParam int doctorId) {
        return doctorDashboardService.getDoctorClinics(doctorId);
    }

    @GetMapping("/medical-notes")
    public List<MedicalNoteDTO> getDoctorMedicalNotes(@RequestParam int doctorId) {
        return doctorDashboardService.getDoctorMedicalNotes(doctorId);
    }

    @PostMapping("/medical-note")
    public void addMedicalNoteToPatient(@RequestBody MedicalNoteDTO medicalNoteDTO) {
        doctorDashboardService.addMedicalNote(medicalNoteDTO);
    }

    @DeleteMapping("/appointment")
    public void deleteAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        doctorDashboardService.deleteAppointment(appointmentDTO);
    }
}
