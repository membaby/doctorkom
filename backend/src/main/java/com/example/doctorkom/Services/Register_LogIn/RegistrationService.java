package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.RepositoryHandler.RepositoryHandler;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    NotificationService notificationService;
    RepositoryHandler repositoryHandler;
    @Autowired
    public RegistrationService(NotificationService notificationService, RepositoryHandler repositoryHandler) {
        this.notificationService = notificationService;
        this.repositoryHandler = repositoryHandler;
    }
    public String register_Patient(Patient patient) throws MessagingException {
        //check if the user exists
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        boolean emailExists = repositoryHandler.EmailAccountExists(account.getEmail());
        boolean usernameExists = repositoryHandler.UsernameAccountExists(account.getUsername());
        if (emailExists) {
            return "email already exists";
        }
        if (usernameExists) {
            return "username already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
        //add account to database
        repositoryHandler.AddAccount(account);
        repositoryHandler.AddSystemUser(systemUser);
        repositoryHandler.AddPatient(patient);
        //store verification code and account in database
            return "";
    }
    public String register_Doctor(Doctor doctor) throws MessagingException {
        //check if the user exists
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        boolean emailExists = repositoryHandler.EmailAccountExists(account.getEmail());
        boolean usernameExists = repositoryHandler.UsernameAccountExists(account.getUsername());
        if (emailExists) {
            return "email already exists";
        }
        if (usernameExists) {
            return "username already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
        //add account to database
        repositoryHandler.AddAccount(account);
        repositoryHandler.AddSystemUser(systemUser);
        repositoryHandler.AddDoctor(doctor);
        //store verification code and account in database
        return "";
    }
    public String register_ClinicAdmin(ClinicAdmin clinicAdmin, String formlink) throws MessagingException {
        //check if the user exists
        Account account = clinicAdmin.getAccount();
        boolean emailExists = repositoryHandler.EmailAccountExists(account.getEmail());
        boolean usernameExists = repositoryHandler.UsernameAccountExists(account.getUsername());
        if (emailExists) {
            return "email already exists";
        }
        if (usernameExists) {
            return "username already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_ClinicAdmin(account.getEmail(),code,formlink);
        //add account to database
        repositoryHandler.AddAccount(account);
        repositoryHandler.AddClinicAdmin(clinicAdmin);
        //store verification code and account in database
        return "";
    }
    public String register_SystemAdmin(SystemAdmin systemAdmin,String formlink) throws MessagingException {
        //check if the user exists
        Account account = systemAdmin.getAccount();
        boolean emailExists = repositoryHandler.EmailAccountExists(account.getEmail());
        boolean usernameExists = repositoryHandler.UsernameAccountExists(account.getUsername());
        if (emailExists) {
            return "email already exists";
        }
        if (usernameExists) {
            return "username already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_SystemAdmin(account.getEmail(),code,formlink);
        //add account to database
        repositoryHandler.AddAccount(account);
        repositoryHandler.AddSystemAdmin(systemAdmin);
        //store verification code and account in database
        return "";
    }

    public String verify(Account account,String code) throws MessagingException {
        //verify the account
        boolean isValid = true;
        if (!isValid) {
            return "Invalid verification code";
        }
        else {
            if (account.getRole() == Role.PATIENT) {
                notificationService.SendPatientCreatedEmail(account.getEmail());
            }
            else if (account.getRole() == Role.DOCTOR) {
                //get doctor name
                SystemUser systemUser = repositoryHandler.findSystemUserById(account.getId());
                String name = systemUser.getFirstName();
                notificationService.SendDoctorCreatedEmail(account.getEmail(),name);
            }
            else if (account.getRole() == Role.CLINIC_ADMIN) {
                notificationService.SendClinicAdminCreatedEmail(account.getEmail());
            }
            else if (account.getRole() == Role.SYSTEM_ADMIN) {
                notificationService.SendSystemAdminCreatedEmail(account.getEmail());
            }
            //update account in database
            return "";
        }
    }

    private String generateVerificationCode() {
        //generate verification code from 100000 to 999999
        return String.valueOf((int) (Math.random() * (999999 - 100000 + 1) + 100000));
    }
}
