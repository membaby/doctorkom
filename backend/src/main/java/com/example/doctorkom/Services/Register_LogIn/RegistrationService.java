package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Services.Notifier.NotificationService;
import com.example.doctorkom.Services.RepositoryHandler.Commander.Command;
import com.example.doctorkom.Services.RepositoryHandler.Commander.ExistenceChecker;
import com.example.doctorkom.Services.RepositoryHandler.RepositoryHandler;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

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
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.executecheck(account.getEmail(),"email");
        String usernameExists = existenceChecker.executecheck(account.getUsername(),"username");
        //if the emailexists is not empty then the email exists same for username
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //add account to database
        Command adder = repositoryHandler.GetCommmand("add");
        adder.executeadd(patient);
        //store verification code and account in database
        Command finder = repositoryHandler.GetCommmand("find");
        patient = finder.executefind(account.getEmail(),"email","patient").getPatient();
        account.setId(patient.getId());
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(account);
        verification.setId(account.getId());
        verification.setCreationTime(LocalDateTime.now());
        adder.executeadd(verification);
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
            return "";
    }
    public String register_Doctor(Doctor doctor) throws MessagingException {
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.executecheck(account.getEmail(),"email");
        String usernameExists = existenceChecker.executecheck(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        Command adder = repositoryHandler.GetCommmand("add");
        adder.executeadd(doctor);
        //store verification code and account in database
        Command finder = repositoryHandler.GetCommmand("find");
        doctor = finder.executefind(account.getEmail(),"email","doctor").getDoctor();
        account.setId(doctor.getId());
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(account);
        verification.setId(account.getId());
        verification.setCreationTime(LocalDateTime.now());
        adder.executeadd(verification);
        //send verification email
        notificationService.VerificationEmail_PD(account.getEmail(),code);
        return "";
    }
    public String register_ClinicAdmin(ClinicAdmin clinicAdmin, String formlink) throws MessagingException {
        Account account = clinicAdmin.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.executecheck(account.getEmail(),"email");
        String usernameExists = existenceChecker.executecheck(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        Command adder = repositoryHandler.GetCommmand("add");
        adder.executeadd(clinicAdmin);
        //store verification code and account in database
        Command finder = repositoryHandler.GetCommmand("find");
        clinicAdmin = finder.executefind(account.getEmail(),"email","clinicAdmin").getClinicAdmin();
        account.setId(clinicAdmin.getAccountID());
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(account);
        verification.setId(account.getId());
        verification.setCreationTime(LocalDateTime.now());
        adder.executeadd(verification);
        //send verification email
        notificationService.VerificationEmail_ClinicAdmin(account.getEmail(),code,formlink);
        return "";
    }
    public String register_SystemAdmin(SystemAdmin systemAdmin,String formlink) throws MessagingException {
        Account account = systemAdmin.getAccount();
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        String emailExists = existenceChecker.executecheck(account.getEmail(),"email");
        String usernameExists = existenceChecker.executecheck(account.getUsername(),"username");
        if (!emailExists.isEmpty()) {
            return emailExists;
        }
        if (!usernameExists.isEmpty()) {
            return usernameExists;
        }
        String code = generateVerificationCode();
        Command adder = repositoryHandler.GetCommmand("add");
        adder.executeadd(systemAdmin);
        //store verification code and account in database
        Command finder = repositoryHandler.GetCommmand("find");
        systemAdmin = finder.executefind(account.getEmail(),"email","systemAdmin").getSystemAdmin();
        account.setId(systemAdmin.getAccountID());
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(account);
        verification.setId(account.getId());
        verification.setCreationTime(LocalDateTime.now());
        adder.executeadd(verification);
        //send verification email
        notificationService.VerificationEmail_SystemAdmin(account.getEmail(),code,formlink);
        return "";
    }

    public String verify(Account account,String code) throws MessagingException {
        //verify the account
        /*-If verified successfully return "success".
        -If code was incorrect but email was correct return "wrong code".
        -If email isn't in the system then return "email not registered".
        -If account is already verified return "already verified*/
        Command finder = repositoryHandler.GetCommmand("find");
        Command existenceChecker = repositoryHandler.GetCommmand("check");
        Command deleter = repositoryHandler.GetCommmand("delete");
        Command adder = repositoryHandler.GetCommmand("add");
        Verification verification = finder.executefind(account);
        if (verification == null) {
            String emailExists = existenceChecker.executecheck(account.getEmail(),"email");
            if (emailExists.isEmpty()) {
                return "email not registered";
            }
            else {
                return "already verified";
            }
        }
        else if (!verification.getCode().equals(code)) {
                return "wrong code";
        }
        //account is verified
        //delete verification from database
        deleter.executedelete(verification);
        account = finder.executefind(account.getEmail());
        deleter.executedelete(account);
        account.setEnabled(true);
        adder.executeadd(account);
        //send email to the user
        if (account.getRole() == Role.PATIENT) {
            notificationService.SendPatientCreatedEmail(account.getEmail());
        }
        else if (account.getRole() == Role.DOCTOR) {
            //get the doctor name from database
            Doctor doctor = finder.executefind(account.getEmail(),"email","doctor").getDoctor();
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
        return "success";

    }


    private String generateVerificationCode() {
        //generate verification code from 100000 to 999999
        return String.valueOf((int) (Math.random() * (999999 - 100000 + 1) + 100000));
    }

}
