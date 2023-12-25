package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.DTOs.AdminMessageDTO;
import com.example.doctorkom.Services.Notifier.NotificationService;

@RestController
public class AdminController {

    @Autowired
    NotificationService notificationService;

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

}

