package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import com.example.doctorkom.Services.Notifier.NotificationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    NotificationService notificationService;
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    public RegistrationService(NotificationService notificationService, AccountRepository accountRepository,SystemUserRepository systemUserRepository) {
        this.notificationService = notificationService;
        this.accountRepository = accountRepository;
        this.systemUserRepository = systemUserRepository;
    }

    public String register(Account account) {
        //check if the user exists
        Account userExists = accountRepository.findByEmail(account.getEmail());
        if (userExists != null) {
            return "User already exists";
        }
        try {
            //send verification email
            notificationService.Send_VerificationEmail(account.getEmail());
            return "Account Created waiting for verification";
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public String verify(String email) {
        //verify the account
        boolean isValid = true;
        if (!isValid) {
            return "Invalid verification code";
        }
        else {
            return "Account verified";
        }
    }

    public String createAccount(Account account) {
        //check if the user exists
        Account userExists = accountRepository.findByEmail(account.getEmail());
        if (userExists != null) {
            return "User already exists";
        }
        else {
            accountRepository.save(account);
            return "Account Created";
        }
    }

}
