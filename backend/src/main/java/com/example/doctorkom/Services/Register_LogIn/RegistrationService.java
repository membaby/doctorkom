package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.RepositoryHandler.Commander.Command;
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
    public String register_Patient(Patient patient){
        //check if the user exists
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.execute(account.getEmail(),"email");
        String usernameExists = existenceChecker.execute(account.getUsername(),"username");
        //if the emailexists is not empty then the email exists same for username
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //send verification email
        try{
            notificationService.VerificationEmail_PD(account.getEmail(),code);
            //add account to database
            Command adder = repositoryHandler.GetCommmand("add");
            adder.execute(patient);
            //store verification code and account in database
                return "";
        } catch (MessagingException e) {
            return "Couldn't send verification email.";
        }
    }
    public String register_Doctor(Doctor doctor){
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.execute(account.getEmail(),"email");
        String usernameExists = existenceChecker.execute(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        try{
            notificationService.VerificationEmail_PD(account.getEmail(),code);
            Command adder = repositoryHandler.GetCommmand("add");
            adder.execute(doctor);
            return "";
        } catch (MessagingException e) {
            return "Couldn't send verification email.";
        }
    }
    public String register_ClinicAdmin(ClinicAdmin clinicAdmin, String formlink) {
        Account account = clinicAdmin.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.execute(account.getEmail(),"email");
        String usernameExists = existenceChecker.execute(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        try{
            notificationService.VerificationEmail_ClinicAdmin(account.getEmail(),code,formlink);
            Command adder = repositoryHandler.GetCommmand("add");
            adder.execute(clinicAdmin);
            return "";
        } catch (MessagingException e) {
            return "Couldn't send verification email.";
        }
        
    }
    public String register_SystemAdmin(SystemAdmin systemAdmin,String formlink) {
        Account account = systemAdmin.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.execute(account.getEmail(),"email");
        String usernameExists = existenceChecker.execute(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        
        try{
            notificationService.VerificationEmail_SystemAdmin(account.getEmail(),code,formlink);
            Command adder = repositoryHandler.GetCommmand("add");
            adder.execute(systemAdmin);
            //store verification code and account in database
            return "";
        } catch (MessagingException e) {
            return "Couldn't send verification email.";
        }
    }

    public String verify(Account account,String code) throws MessagingException {
        //verify the account
        /*-If verified successfully return "success".
        -If code was incorrect but email was correct return "wrong code".
        -If email isn't in the system then return "email not registered".
        -If account is already verified return "already verified*/
        boolean isValid = true;
        if (!isValid) {
            return "Invalid verification code";
        }
        else {
            if (account.getRole() == Role.PATIENT) {
                notificationService.SendPatientCreatedEmail(account.getEmail());
            }
            else if (account.getRole() == Role.DOCTOR) {
                //get the doctor name from database
                Command finder = repositoryHandler.GetCommmand("find");
                Doctor doctor = finder.execute(account.getEmail(),"email","doctor").getDoctor();
                SystemUser systemUser = doctor.getSystemUser();
                notificationService.SendDoctorCreatedEmail(account.getEmail(),systemUser.getFirstName());
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
