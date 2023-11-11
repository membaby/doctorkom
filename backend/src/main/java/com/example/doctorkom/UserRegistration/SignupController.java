package com.example.doctorkom.UserRegistration;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@PutMapping("/patient")
	public String patientSignup(@RequestBody SignupInfoDTO signupRequest) {
		String err = ""; //err is an error message. If there is no problem with the signup info then err will be empty.
		return err;
	}

	@PutMapping("/doctor")
	public String doctorSignup(@RequestBody DoctorSignupInfo signupInfo)
	{
		String err = ""; //err is an error message. If there is no problem with the signup info then err will be empty.
		return err;
	}

}


class SignupInfoDTO{
	public String email, username, firstName, lastName, password, address, landline, mobile, Birthdate;
	public int age;
	public byte gender; //0 for male, 1 for female
}

class DoctorSignupInfo extends SignupInfoDTO{
	public String specialty, title;
}