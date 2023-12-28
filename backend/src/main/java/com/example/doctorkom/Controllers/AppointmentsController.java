package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Services.DashboardServices.DoctorDashboardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// This is generic for appointments and does have anything to do with getting specific appointments for a specific user
@RestController
@RequestMapping("/Appointments")
public class AppointmentsController {
    @GetMapping("/{appointmentId}")
    public String getAppointment(@PathVariable int appointmentId) {
        return "Appointments";
    }

    @PostMapping
    public String addAppointment(){
        return "Appointments";
    }

    @PutMapping
    public String updateAppointment(){
        return "Appointments";
    }

    @DeleteMapping("/{appointmentId}")
    public String deleteAppointment(@PathVariable int appointmentId){
        return "Appointments";
    }
}
