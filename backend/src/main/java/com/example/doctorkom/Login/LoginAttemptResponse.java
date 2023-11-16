package com.example.doctorkom.Login;

import com.example.doctorkom.Entities.Account;

public class LoginAttemptResponse {
    public boolean success;
    public Account account;

    public LoginAttemptResponse(boolean success, Account account){
        this.success = success;
        this.account = account;
    }
}
