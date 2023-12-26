package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.Controllers.SignupController.SignupResponse;
import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.AdminMessageDTO;
import com.example.doctorkom.Services.AdminTools.ClinicManagementService;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

    @Autowired
    NotificationService notificationService;
    @Autowired
    RegistrationService registrationService;
    @Autowired
    ClinicManagementService clinicManagementService;
    @Autowired
    AccountMapper accountMapper;


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
    public SignupResponse createClinic(@RequestBody AccountDTO account) {
        String msg = registrationService.registerClinicAdmin(accountMapper.toEntity(account));
        
        return new SignupResponse(msg, msg.isEmpty());
    }

    @PostMapping("/removeClinic")
    public SignupResponse removeClinic(@RequestBody String accountEmail) {
        String msg = clinicManagementService.removeClinic(accountEmail);
        
        return new SignupResponse(msg, msg.isEmpty());
    }
    
    

}

