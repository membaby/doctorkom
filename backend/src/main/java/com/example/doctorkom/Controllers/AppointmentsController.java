package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.*;

// This is generic for appointments and does have anything to do with getting specific appointments for a specific user
@RestController
@RequestMapping("/Appointments")
public class AppointmentsController {
    @GetMapping
    public String getAllAppointments(){
        return "Appointments";
    }

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
