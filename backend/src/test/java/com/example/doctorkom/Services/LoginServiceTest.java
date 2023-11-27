package com.example.doctorkom.Services;

import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Services.Register_LogIn.LogInService;

public class LoginServiceTest {
    
    @Autowired
    LogInService logInService;

    @Test
    public void invalidLoginEmailOrUsername() {//Perform login with invalid email or username
        //Perform login with an email or username that doesn't exist in the database
        //Confirm an unsuccessful login
        Account testAccount = new Account();
        testAccount.setEmail("guygujgk");
        testAccount.setUsername("guygujgk");
        testAccount.setPassword("1");
        assertNull(logInService.login(testAccount));
    }

    @Test
    public void invalidLoginPassword() { //Perform login with valid email or username but invalid password
        //Perform login with valid email or username but invalid password
        //Confirm an unsuccessful login
    }

    @Test
    public void loginWithAnotherPassword()
    {
        //Perform login with a valid email but another account's password
        //Confirm unsuccessful login
    }
    
    @Test
    public void validLoginWithEmail() {
        //Perform login with valid email and password.
        //Confirm successful login
    }

    @Test
    public void validLoginWithUsername() {
        //Perform login with valid username and password.
        //Confirm successful login
    }

    @Test
    public void loginBeforeVerification() {
        //register a new account successfully
        //Perform login.
        //Confirm unsuccessful login
        //Delete Registered Account
    }

    @Test
    public void loginAfterVerification() {
        //Login to a verified account
        //Confirm successful login
    }

    @Test
    public void loginAsPatient() {
       //login to a patient account
       //Confirm account type is patient
    }

    @Test
    public void loginAsDoctor() {
        //login to a doctor account
        //confirm account type is doctor
    }

    @Test
    public void loginAsClinic() {
        //login to a clinic account
        //confirm account type is clinic_admin
    }

    @Test
    public void loginAsSystemAdmin() {
        //login to a system admin account
        //confirm account type is system_admin
    }
}
