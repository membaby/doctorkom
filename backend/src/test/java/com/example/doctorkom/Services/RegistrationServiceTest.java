package com.example.doctorkom.Services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.Entities.Gender;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Entities.SystemUser;
import com.example.doctorkom.Entities.Verification;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import com.example.doctorkom.Repositories.VerificationRepository;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

@SpringBootTest
public class RegistrationServiceTest {
    
    @Autowired
    RegistrationService regService;
    @Autowired
    AccountRepository accountRepo;
    @Autowired
    SystemUserRepository userRepo;
    @Autowired
    PatientRepository patientRepo;
    @Autowired
    DoctorRepository doctorRepo;
    @Autowired
    VerificationRepository verifyRepo;

    // @Test
    // void verifyAccount() //Verifies an account that is unverified
    // {
    //     Doctor doctor = getTestDoctor();
    //     if (accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).orElse(null) != null){
    //         accountRepo.delete(doctor.getSystemUser().getAccount());
    //     }
    //     regService.registerDoctor(doctor);
    //     Account createdAccount = accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).get();
    //     Verification verification = verifyRepo.findById(createdAccount.getId()).get();
    //     regService.verify(createdAccount, verification.getCode());
    //     assertTrue(accountRepo.findById(createdAccount.getId()).get().isEnabled());
    //     assertNull(verifyRepo.findById(createdAccount.getId()).orElse(null));
    // }

//    @Test
//    void registerValidPatient() //Registers a new patient and confirms it is unverified
//    {
//        Patient patient = getTestPatient();
//        SystemUser user = patient.getSystemUser();
//        Account account = user.getAccount();
//        //Delete account if it already exists
//        if(accountRepo.findByEmail(account.getEmail()).orElse(null) != null){
//            accountRepo.delete(accountRepo.findByEmail(account.getEmail()).orElse(null));
//        }
//        String result = regService.registerPatient(patient);
//        assertTrue(result.isEmpty());
//        assertNotNull(accountRepo.findByEmail(account.getEmail()).orElse(null));
//        assertNotNull(accountRepo.findByUsername(account.getUsername()).orElse(null));
//        Account createdAccount = accountRepo.findByEmail(account.getEmail()).orElse(null);
//        assertNotNull(userRepo.findById(createdAccount.getId()).orElse(null));
//        assertNotNull(patientRepo.findById(createdAccount.getId()).orElse(null));
//        assertNotNull(verifyRepo.findById(createdAccount.getId()).orElse(null));
//        assertEquals(false, createdAccount.isEnabled());
//        accountRepo.delete(createdAccount);
//    }
//
//    @Test
//    void registerValidDoctor() //Registers a new doctor and confirms it is unverified
//    {
//        Doctor doctor = getTestDoctor();
//        SystemUser user = doctor.getSystemUser();
//        Account account = user.getAccount();
//        //Delete account if it already exists
//        if(accountRepo.findByEmail(account.getEmail()).orElse(null) != null){
//            accountRepo.delete(accountRepo.findByEmail(account.getEmail()).orElse(null));
//        }
//        String result = regService.registerDoctor(doctor);
//        assertTrue(result.isEmpty());
//        assertNotNull(accountRepo.findByEmail(account.getEmail()).orElse(null));
//        assertNotNull(accountRepo.findByUsername(account.getUsername()).orElse(null));
//        Account createdAccount = accountRepo.findByEmail(account.getEmail()).orElse(null);
//        assertNotNull(userRepo.findById(createdAccount.getId()).orElse(null));
//        assertNotNull(doctorRepo.findById(createdAccount.getId()).orElse(null));
//        assertNotNull(verifyRepo.findById(createdAccount.getId()).orElse(null));
//        assertEquals(false, createdAccount.isEnabled());
//        accountRepo.delete(createdAccount);
//    }
//
//    @Test
//    void registerUsedEmail() //Registers a new user with an email that is already in use
//    {
//        Patient temPatient = getTestPatient();
//        if (accountRepo.findByEmail(temPatient.getSystemUser().getAccount().getEmail()).orElse(null) == null){
//            regService.registerPatient(temPatient);
//        }
//        Account account = new Account();
//        account.setEmail("swe.test.patient@gmail.com");
//        account.setUsername("my-username");
//        SystemUser user = new SystemUser();
//        Doctor doctor = new Doctor();
//        doctor.setSystemUser(user);
//        user.setAccount(account);
//        assertEquals(regService.EMAIL_EXISTS, regService.registerDoctor(doctor));
//    }
//
//    @Test
//    void registerUsedUsername() //Registers a new user with a username that is already in use
//    {
//        Patient temPatient = getTestPatient();
//        if (accountRepo.findByEmail(temPatient.getSystemUser().getAccount().getEmail()).orElse(null) == null){
//            regService.registerPatient(temPatient);
//        }
//        Account account = new Account();
//        account.setEmail("a@b.c");
//        account.setUsername("new-patient");
//        SystemUser user = new SystemUser();
//        Doctor doctor = new Doctor();
//        doctor.setSystemUser(user);
//        user.setAccount(account);
//        assertEquals(regService.USERNAME_EXISTS, regService.registerDoctor(doctor));
//    }

    // @Test
    // void verifyWithWrongCode() //Tries to verify an account with a wrong code
    // {
        // Doctor doctor = getTestDoctor();
        // if (accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).orElse(null) != null){
        //     accountRepo.delete(doctor.getSystemUser().getAccount());
        // }
        // regService.registerDoctor(doctor);
        // Account createdAccount = accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).get(); 
        // Verification verification = verifyRepo.findById(createdAccount.getId()).get();
        // regService.verify(doctor.getSystemUser().getAccount(), verification.getCode());
    // }

    // @Test
    // void verifyWithAnotherCode() //Tries to verify an account with another account's code
    // {
    //     Doctor doctor = getTestDoctor();
    //     if (accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).orElse(null) != null){
    //         accountRepo.delete(doctor.getSystemUser().getAccount());
    //     }
    //     regService.registerDoctor(doctor);
    //     Account createdAccount = accountRepo.findByEmail(doctor.getSystemUser().getAccount().getEmail()).get(); 
    //     Verification verification = verifyRepo.findById(createdAccount.getId()).get();
    //     regService.verify(doctor.getSystemUser().getAccount(), verification.getCode());
    // }

    


//    Patient getTestPatient()
//    {
//        Account account = new Account();
//        SystemUser user = new SystemUser();
//        Patient patient = new Patient();
//        account.setEmail("swe.test.patient@gmail.com");
//        account.setUsername("new-patient");
//        account.setPassword("123");
//        account.setRole(Role.PATIENT);
//        user.setFirstName("james");
//        user.setLastName("corbett");
//        user.setAccount(account);
//        user.setBirthdate(Date.valueOf(LocalDate.now()));
//        user.setGender(Gender.FEMALE);
//        user.setMobilePhone("1234567890");
//        user.setAddress("alexandria");
//        patient.setSystemUser(user);
//        patient.setOccupation("student");
//        patient.setMaritalStatus("married");
//        return patient;
//    }
//
//    Doctor getTestDoctor()
//    {
//        Account account = new Account();
//        SystemUser user = new SystemUser();
//        Doctor doctor = new Doctor();
//        account.setEmail("swe.test.doctor@gmail.com");
//        account.setUsername("new-doctor");
//        account.setPassword("123");
//        account.setRole(Role.DOCTOR);
//        user.setFirstName("james");
//        user.setLastName("corbett");
//        user.setAccount(account);
//        user.setBirthdate(Date.valueOf(LocalDate.now()));
//        user.setGender(Gender.MALE);
//        user.setMobilePhone("6876887687");
//        user.setAddress("alexandria");
//        doctor.setSystemUser(user);
//        doctor.setSpecialty(DoctorSpecialty.ANESTHESIOLOGIST);
//        doctor.setTitle(DoctorTitle.LECTURER);
//        return doctor;
//    }
}
