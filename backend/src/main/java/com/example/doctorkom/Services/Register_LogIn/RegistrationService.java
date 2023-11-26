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
    public String register_Patient(Account account, Patient patient,SystemUser systemUser) throws MessagingException {
        //check if the user exists
        boolean accountExists = repositoryHandler.AccountExists(account.getEmail(),account.getUsername());
        if (accountExists) {
            return "Account already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
        //add account to database
        repositoryHandler.createAccount(account);
        repositoryHandler.createSystemUser(systemUser);
        repositoryHandler.createPatient(patient);
        //store verification code and account in database
            return "";
    }
    public String register_Doctor(Account account, Doctor doctor, SystemUser systemUser) throws MessagingException {
        //check if the user exists
        boolean accountExists = repositoryHandler.AccountExists(account.getEmail(),account.getUsername());
        if (accountExists) {
            return "Account already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
        //add account to database
        repositoryHandler.createAccount(account);
        repositoryHandler.createSystemUser(systemUser);
        repositoryHandler.createDoctor(doctor);
        //store verification code and account in database
        return "";
    }
    public String register_ClinicAdmin(Account account, ClinicAdmin clinicAdmin, String formlink) throws MessagingException {
        //check if the user exists
        boolean accountExists = repositoryHandler.AccountExists(account.getEmail(),account.getUsername());
        if (accountExists) {
            return "Account already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_ClinicAdmin(account.getEmail(),code,formlink);
        //add account to database
        repositoryHandler.createAccount(account);
        repositoryHandler.createClinicAdmin(clinicAdmin);
        //store verification code and account in database
        return "";
    }
    public String register_SystemAdmin(Account account, SystemAdmin systemAdmin, String formlink) throws MessagingException {
        //check if the user exists
        boolean accountExists = repositoryHandler.AccountExists(account.getEmail(),account.getUsername());
        if (accountExists) {
            return "Account already exists";
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        notificationService.VerificationEmail_SystemAdmin(account.getEmail(),code,formlink);
        //add account to database
        repositoryHandler.createAccount(account);
        repositoryHandler.createSystemAdmin(systemAdmin);
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
        String code = String.valueOf((int) (Math.random() * (999999 - 100000 + 1) + 100000));
        //add space between every 3 digits
        return code;
    }

}
