package com.example.doctorkom.Services;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;

import com.example.doctorkom.Repositories.AccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Services.Register_LogIn.LogInService;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;

@SpringBootTest
public class LoginServiceTest {

    @Autowired
    LogInService loginService;

    @Test
    public void invalidLoginEmailAndUsername() {//Perform login with invalid email and username
        //Perform login with an email or username that doesn't exist in the database
        //Confirm an unsuccessful login
        Account testAccount = new Account();
        testAccount.setEmail("guygujgk");
        testAccount.setUsername("guygujgk");
        testAccount.setPassword("1");
        assertNull(loginService.login(testAccount));
    }

    @Test
    public void invalidLoginPassword() {
        //Perform login with valid email or username but invalid password
        //Confirm an unsuccessful login
        Account account = new Account("swe.test.patient2@gmail.com", "swe.test.patient2@gmail.com", "patient", null);
        assertNull(loginService.login(account));
    }

    @Test
    public void invalidLoginWithAnotherPassword()
    {
        //Perform login with a valid email but another account's password
        //Confirm unsuccessful login
        Account account = new Account("swe.test.system@gmail.com", "swe.test.system@gmail.com", "patient", null);
        assertNull(loginService.login(account));
    }
    
    @Test
    public void validLoginWithEmail() {
        //Perform login with valid email and password.
        //Confirm successful login
        Account account = new Account("swe.test.patient2@gmail.com", "swe.test.patient2@gmail.com", "123", null);
        EntityWrapper fullAccount = loginService.login(account);
        assertNotNull(fullAccount);
        assertNotNull(fullAccount.getPatient());
    }

    @Test
    public void validLoginWithUsername() {
        //Perform login with valid username and password.
        //Confirm successful login
        Account account = new Account("verified_patient", "verified_patient", "123", null);
        EntityWrapper fullAccount = loginService.login(account);
        assertNotNull(fullAccount);
        assertNotNull(fullAccount.getPatient());
    }

    @Test
    public void loginBeforeVerification() {
        // Perform login with unverified account.
        // Confirm unsuccessful login
        assertNull(loginService.login(new Account("swe.test.patient@gmail.com", "swe.test.patient@gmail.com", "123", null)));
    }


    @Test
    public void loginAsPatient() {
       //login to a patient account
       //Confirm account type is patient
        Account account = new Account("swe.test.patient2@gmail.com", "swe.test.patient2@gmail.com", "123", null);
        EntityWrapper fullAccount = loginService.login(account);
        assertNotNull(fullAccount);
        assertTrue(fullAccount.getRole().equals("PATIENT"));
        assertNotNull(fullAccount.getPatient());
    }
    
    @Test
    public void loginAsDoctor() {
        //login to a doctor account
        //confirm account type is doctor
        Account account = new Account("swe.test.doctor@gmail.com", "swe.test.doctor@gmail.com", "doctor", null);
        EntityWrapper fullAccount = loginService.login(account);
        assertNotNull(fullAccount);
        assertTrue(fullAccount.getRole().equals("DOCTOR"));
        assertNotNull(fullAccount.getDoctor());
    }

    // @Test
    // public void loginAsClinic() {
    //     //login to a clinic account
    //     //confirm account type is clinic_admin
    //     Account account = new Account("swe.test.clinic@gmail.com", "swe.test.clinic@gmail.com", "clinic", null);
    //     EntityWrapper fullAccount = loginService.login(account);
    //     assertNotNull(fullAccount);
    //     assertNotNull(fullAccount.getClinicAdmin());
    // }

    // @Test
    // public void loginAsSystemAdmin() {
    //     //login to a system admin account
    //     //confirm account type is system_admin
    //     Account account = new Account("swe.test.system@gmail.com", "swe.test.system@gmail.com", "admin", null);
    //     EntityWrapper fullAccount = loginService.login(account);
    //     assertNotNull(fullAccount);
    //     assertNotNull(fullAccount.getSystemAdmin());
    // }

}
