package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Services.EntityServices.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/timeslot")
public class TimeSlotController {
    final private TimeSlotService timeSlotService;

    @Autowired
    public TimeSlotController(TimeSlotService timeSlotService) {
        this.timeSlotService = timeSlotService;
    }

    @GetMapping("/{doctorId}")
    public List<Object> getDoctorTimeSlots(@PathVariable int doctorId) {
        return timeSlotService.getTimeSlotsByDoctorId(doctorId);
    }
}
