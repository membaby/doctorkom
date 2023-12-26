package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import com.example.doctorkom.Services.Notifier.NotificationService;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class RegistrationService {


    NotificationService notificationService;
    AccountRepository accountRepository;
    PatientRepository patientRepository;
    DoctorRepository doctorRepository;
    ClinicRepository clinicRepository;
    SystemAdminRepository systemAdminRepository;
    VerificationRepository verificationRepository;

    //Registration messages
    @Autowired
    void publicRegistrationService( NotificationService notificationService,
                                    AccountRepository accountRepository,
                                    PatientRepository patientRepository,
                                    DoctorRepository doctorRepository,
                                    ClinicRepository clinicRepository,
                                    SystemAdminRepository systemAdminRepository,
                                    VerificationRepository verificationRepository){
        this.notificationService = notificationService;
        this.accountRepository = accountRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.clinicRepository = clinicRepository;
        this.systemAdminRepository = systemAdminRepository;
        this.verificationRepository = verificationRepository;
    }
    public final String EMAIL_EXISTS = "Email already exists.";
    public final String USERNAME_EXISTS = "Username already exists.";
    public final String MOBILE_EXISTS = "Mobile phone already exists.";
    //Verification messages
    public final String NOT_REGISTERED = "Email is not registered.";
    public final String WRONG_CODE = "Wrong code.";
    public final String ALREADY_ = "Wrong code.";
    public final String SUCCESS = "Account verified";
    


    public String registerPatient(Patient patient){
        //check if the user exists
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        boolean emailExists = accountRepository.existsByEmail(account.getEmail());
        boolean usernameExists = accountRepository.existsByUsername(account.getUsername());
        //if the emailexists is not empty then the email exists same for username
        if (emailExists) {

            return EMAIL_EXISTS;
        }
        if (usernameExists) {
            return USERNAME_EXISTS;
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //add account to database
        patientRepository.save(patient);
        Account newaccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
        //store verification code and account in database
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(newaccount);
        verification.setId(newaccount.getId());
        verification.setExpirationTime(LocalDateTime.now().plusDays(1));
        verificationRepository.save(verification);
        //send verification email
        try{
            notificationService.VerificationEmail_PD(account.getEmail(),code);
            return "";
        } catch (MessagingException e) {
            return "Could not send verification email. Problem with notification service";
        }
    }
    
    
    public String registerDoctor(Doctor doctor) {
        //same as register patient code
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        boolean emailExists = accountRepository.existsByEmail(account.getEmail());
        boolean usernameExists = accountRepository.existsByUsername(account.getUsername());
        //if the emailexists is not empty then the email exists same for username
        if (emailExists) {
            return EMAIL_EXISTS;
        }
        if (usernameExists) {
            return USERNAME_EXISTS;
        }
        //generate verification code from 100000 to 999999
        String code = generateVerificationCode();
        //add account to database
        doctorRepository.save(doctor);
        Account newaccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
        //store verification code and account in database
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setAccount(newaccount);
        verification.setId(newaccount.getId());
        verification.setExpirationTime(LocalDateTime.now().plusDays(1));
        verificationRepository.save(verification);
        //send verification email
        try{
            notificationService.VerificationEmail_PD(account.getEmail(),code);
            return "";
        } catch (MessagingException e) {
            return "Could not send verification email. Problem with notification service";
        }
    }

    public String registerClinic(Clinic clinic, Account account) {
        //check if the user exists
        boolean emailExists = accountRepository.existsByEmail(account.getEmail());
        boolean usernameExists = accountRepository.existsByUsername(account.getUsername());
        //if the emailexists is not empty then the email exists same for username
        if (emailExists) {
            return EMAIL_EXISTS;
        }
        if (usernameExists) {
            return USERNAME_EXISTS;
        }
        account.setRole(Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        clinicAdmin.setAccount(account);
        clinic.setAdmin(clinicAdmin);
        clinicRepository.save(clinic);
        //store verification code and account in database
        String code = generateVerificationCode();
        Verification verification = new Verification();
        verification.setCode(code);
        verification.setId(account.getId());
        verification.setAccount(account);
        verification.setExpirationTime(LocalDateTime.now().plusDays(1));
        verificationRepository.save(verification);
        //send verification email
        try{
            notificationService.VerificationEmail_ClinicAdmin(account.getEmail(),code);
            return "";
        } catch (MessagingException e) {
            return "Could not send verification email. Problem with notification service";
        }
    }

    public String registerSystemAdmin(SystemAdmin systemAdmin,String formlink) {
        //check if the user exists
        ///same as register clinic admin
        Account account = systemAdmin.getAccount();
        boolean emailExists = accountRepository.existsByEmail(account.getEmail());
        boolean usernameExists = accountRepository.existsByUsername(account.getUsername());
        //if the emailexists is not empty then the email exists same for username
        if (emailExists) {
            return EMAIL_EXISTS;
        }
        if (usernameExists) {
            return USERNAME_EXISTS;
        }
        String code = generateVerificationCode();
        systemAdminRepository.save(systemAdmin);
        Account newaccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
        //store verification code and account in database
        Verification verification = new Verification();
        verification.setCode(code);

        verification.setAccount(newaccount);
        verification.setId(newaccount.getId());
        verification.setExpirationTime(LocalDateTime.now().plusDays(1));
        verificationRepository.save(verification);
        //send verification email
        try{
            notificationService.VerificationEmail_SystemAdmin(account.getEmail(),code,formlink);
            return "";
        } catch (MessagingException e) {
            return "Could not send verification email. Problem with notification service";
        }
    }

    public String verify(Account account,String code){
        //verify the account
        /*-If verified successfully return "success".
        -If code was incorrect but email was correct return "wrong code".
        -If email isn't in the system then return "email not registered".
        -If account is already verified return "already verified*/
        // Command adder = repositoryHandler.GetCommmand("add");
        System.out.println(account);
        System.out.println("account id: " + account.getId());
        account = accountRepository.findByEmail(account.getEmail()).orElse(null);
        assert account != null;
        Verification verification = verificationRepository.findById(account.getId()).orElse(null);
        if (verification == null) {
            boolean emailExists = accountRepository.existsByEmail(account.getEmail());
            if (!emailExists) {
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
        Account fullAccount = verification.getAccount();
        //set account verified to true
        fullAccount.setEnabled(true);
        accountRepository.save(fullAccount);
        //delete verification from database
        verificationRepository.delete(verification);
        //send email to the user
        try{
            if (fullAccount.getRole() == Role.PATIENT) {
                notificationService.SendPatientCreatedEmail(fullAccount.getEmail());
            }
            else if (fullAccount.getRole() == Role.DOCTOR) {
                //get the doctor name from database
                Doctor doctor = doctorRepository.findById(fullAccount.getId()).orElse(null);
                SystemUser systemUser = doctor.getSystemUser();
                notificationService.SendDoctorCreatedEmail(fullAccount.getEmail(),systemUser.getFirstName());
            }
            else if (fullAccount.getRole() == Role.CLINIC_ADMIN) {
                notificationService.SendClinicAdminCreatedEmail(fullAccount.getEmail());
            }
            else if (fullAccount.getRole() == Role.SYSTEM_ADMIN) {
                notificationService.SendSystemAdminCreatedEmail(fullAccount.getEmail());
            }
                //update account in database
            return "success";
        }catch (MessagingException e){
            return "Could not send verification email. Problem with notification service";
        }

    }

    private String generateVerificationCode() {
        //generate verification code from 100000 to 999999
        return String.valueOf((int) (Math.random() * (999999 - 100000 + 1) + 100000));
    }

}
