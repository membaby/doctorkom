package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Entities.SystemUser;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    SystemUserRepository systemUserRepository;

    @Autowired
    public LogInService(AccountRepository accountRepository, SystemUserRepository systemUserRepository) {
        this.accountRepository = accountRepository;
        this.systemUserRepository = systemUserRepository;
    }

    public String login(Account account) {
        //check if the user exists
        Account userExists = accountRepository.findByEmail(account.getEmail());
        if (userExists == null) {
            return "User doesn't exist";
        }
        else {
            return "Logged in";
        }
    }
    public SystemUser getAccountInfo(String email) {
        Account user = accountRepository.findByEmail(email);
        int id = user.getId();
        Role role = user.getRole();
        if (role == Role.PATIENT) {
            return systemUserRepository.findById(id).orElse(null);
        }
        else if (role == Role.DOCTOR) {
            return systemUserRepository.findById(id).orElse(null);
        }
        else if (role == Role.SYSTEM_ADMIN) {
            return systemUserRepository.findById(id).orElse(null);
        }
        else if (role == Role.CLINIC_ADMIN) {
            return systemUserRepository.findById(id).orElse(null);
        }
        else {
            return null;
        }
    }
}

