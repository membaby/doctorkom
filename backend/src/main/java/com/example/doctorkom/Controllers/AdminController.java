package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.Controllers.SignupController.BoolMessage;
import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOs.AdminMessageDTO;
import com.example.doctorkom.DTOs.ClinicAccountInfo;
import com.example.doctorkom.Services.AdminTools.ClinicManagementService;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    NotificationService notificationService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    ClinicManagementService clinicManagementService;
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    ClinicMapper clinicMapper;


    @PostMapping("/sendAdminMessage")
    public String sendAdminMessage(@RequestBody AdminMessageDTO adminMessageDTO) {
        System.out.println("Sending message to " + adminMessageDTO.getEmail());
        try {
            notificationService.CustomEmail(adminMessageDTO.getEmail(), "New message from Doctorkom Admin", adminMessageDTO.getMessage());
            return "Message sent successfully";
        } catch (Exception e) {
            return "Message sending failed";
        }
    }

    @PostMapping("/createClinic")
    public BoolMessage createClinic(@RequestBody ClinicAccountInfo clinicInfo) {
        String msg = registrationService.registerClinic(clinicMapper.toEntity(clinicInfo.getClinic()), accountMapper.toEntity(clinicInfo.getAccount()));
        return new BoolMessage(msg, msg.isEmpty());
    }

    @PostMapping("/removeClinic")
    public BoolMessage removeClinic(@RequestBody String accountEmail) {
        String msg = clinicManagementService.removeClinic(accountEmail);
        return new BoolMessage(msg, msg.isEmpty());
    }
    
}



