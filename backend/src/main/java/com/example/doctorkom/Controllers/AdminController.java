package com.example.doctorkom.Controllers;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.doctorkom.Controllers.SignupController.SignupResponse;
import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.AdminMessageDTO;
import com.example.doctorkom.Entities.SystemAdmin;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.AdminTools.InsightsService;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

import java.util.HashMap;


@RestController
@RequestMapping("/admin")
public class AdminController {

    NotificationService notificationService;
    RegistrationService regisService;
    AccountMapper accountMapper;

    public AdminController(
        NotificationService notificationService, 
        RegistrationService regisService, 
        AccountMapper accountMapper) {
        this.notificationService = notificationService;
        this.regisService = regisService;
        this.accountMapper = accountMapper;
    }

    @Autowired
    InsightsService insightsService;

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

    @GetMapping("/adminInsights")
    public HashMap<String, Integer> adminInsights() {
        return insightsService.getTotalRowCounts();
    }

    @PostMapping("/createAdmin")
    public SignupResponse createAdmin(@RequestBody AccountDTO accountDTO)
    {
        String msg = regisService.registerSystemAdmin(SystemAdmin.builder().account(accountMapper.toEntity(accountDTO)).build());
        return new SignupResponse(msg, msg.isEmpty());
    }
    
}

