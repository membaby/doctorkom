package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.AdminMessageDTO;
import com.example.doctorkom.Entities.SystemAdmin;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

    @Autowired
    NotificationService notificationService;
    @Autowired
    RegistrationService regisService;
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


    @PostMapping("/create-admin")
    public String createAdmin(@RequestBody AccountDTO accountDTO)
    {
        return regisService.registerSystemAdmin(SystemAdmin.builder().account(accountMapper.toEntity(accountDTO)).build());
    }
    

}

