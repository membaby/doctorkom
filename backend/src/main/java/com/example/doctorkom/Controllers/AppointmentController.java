package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.Controllers.SignupController.SignupResponse;
import com.example.doctorkom.DTOMappers.AppointmentMapper;
import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Services.AppointmentManagementService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/appointments")
public class AppointmentController 
{

    private final AppointmentManagementService appointmentManagementService;
    private final AppointmentMapper appointmentMapper;
    
    public AppointmentController(AppointmentManagementService appointmentManagementService, AppointmentMapper appointmentMapper) {
        this.appointmentManagementService = appointmentManagementService;
        this.appointmentMapper = appointmentMapper;
    }


    @PostMapping("/bookAppointment")
    public SignupResponse bookAppointment(@RequestBody AppointmentDTO appointmentDTO) {
        Appointment appnt = appointmentMapper.toEntity(appointmentDTO);
        String msg = appointmentManagementService.bookAppointment(appnt.getPatient().getId(), appnt.getTimeSlot());
        
        return new SignupResponse(msg, msg.isEmpty());
    }
    

}
