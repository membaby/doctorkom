package com.example.doctorkom.Services.Register;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Services.Notifier.NotificationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    NotificationService notificationService;

    @Autowired
    public RegistrationService(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    public String register(Account account) {
        //insert into database and check if the account is valid
        Boolean isValid = true;
        if (!isValid) {
            return "Invalid Account";
        }
        try {
            //if the account is valid the account will be added to the database and blocked
            //send verification email
            notificationService.Send_VerificationEmail(account.getEmail());
            return "Account Created waiting for verification";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String verify(String email) {
        //verify the account
        Boolean isValid = true;
        if (!isValid) {
            return "Invalid Account";
        }
        try {
            //if the account is valid the account will be enabled
            //send verification email
            notificationService.SendPatientCreatedEmail(email);
            return "Account Created";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
