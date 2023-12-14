package com.example.doctorkom.Controllers.VerificationController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

@RestController
public class VerificationController {

    @Autowired
    RegistrationService registrationService;

    @GetMapping("/verify")
    public String verify(@RequestParam(name="email")String email, @RequestParam(name="code") String code) {
        System.out.println("Verifying account");
        Account account = new Account();
        account.setEmail(email);
        return registrationService.verify(account, code);
    }

}

