package com.example.doctorkom.Controllers;

public class SignupResponse {
    public String msg;
	public boolean success;

	public SignupResponse(String msg, boolean success){
		this.msg = msg;
		this.success = success;
	}
}
