package com.example.doctorkom.UserRegistration;

import org.springframework.web.bind.annotation.*;

@RestController
public class SignupController {
	
	@PutMapping("/signup")
	public String signup(@RequestBody SignupInfoDTO signupRequest) {
		String err = ""; //err is an error message. If there is no problem with the signup info then err will be empty.
		return err;
	}
}


class SignupInfoDTO{
	String email, username, firstName, lastName, password, address, landline, mobile, Birthdate;
	int age;
	byte type; //0 for patient, 1 for doctor
	byte gender; //0 for male, 1 for female
}
