package com.example.doctorkom.UserRegistration;
import java.sql.Date;
import java.util.HashMap;

import org.springframework.web.bind.annotation.*;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.User;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.Entities.Gender;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@PutMapping("/patient")
	public SignupResponse patientSignup(@RequestBody SignupRequest request) {
		//Create account, user and patient objects.
		//Create account
		Account account = new Account();
		account.setEmail(request.email);
		account.setUsername(request.username);
		account.setPassword(request.password);
		//Create user
		User user = new User();
		user.setFirstName(request.firstName);
		user.setLastName(request.lastName);
		user.setBirthdate(Date.valueOf(request.Birthdate));
		user.setGender(request.gender.equalsIgnoreCase("male") ? Gender.Male : Gender.Female);
		user.setAddress(request.address);
		user.setMobilePhone(request.mobile);
		user.setLandlinePhone(request.landline);
		//Create Patient
		Patient patient = new Patient();
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().registerPatient(account, user, patient);
		boolean success = msg.isEmpty();
		SignupResponse response = new SignupResponse();
		response.msg = msg;
		response.success = success;
		return response;
	}

	HashMap<String, DoctorTitle> titleMap = new HashMap<String, DoctorTitle>();
	{
		titleMap.put("professor", DoctorTitle.Professor);
		titleMap.put("lecturer", DoctorTitle.Lecturer);
		titleMap.put("consultant", DoctorTitle.Consultant);
		titleMap.put("specialist", DoctorTitle.Specialist);
	}
	HashMap<String, DoctorSpecialty> specialtyMap = new HashMap<String, DoctorSpecialty>();
	{
		specialtyMap.put("general practitioner", DoctorSpecialty.GeneralPractitioner);
		specialtyMap.put("cardiologist", DoctorSpecialty.Cardiologist);
		specialtyMap.put("dermatologist", DoctorSpecialty.Dermatologist);
		specialtyMap.put("pediatrician", DoctorSpecialty.Pediatrician);
		specialtyMap.put("orthopedic surgeon", DoctorSpecialty.OrthopedicSurgeon);
		specialtyMap.put("gynecologist", DoctorSpecialty.Gynecologist);
		specialtyMap.put("ophthalmologist", DoctorSpecialty.Ophthalmologist);
		specialtyMap.put("neurologist", DoctorSpecialty.Neurologist);
		specialtyMap.put("urologist", DoctorSpecialty.Urologist);
		specialtyMap.put("ent specialist", DoctorSpecialty.ENTSpecialist);
		specialtyMap.put("psychiatrist", DoctorSpecialty.Psychiatrist);
		specialtyMap.put("oncologist", DoctorSpecialty.Oncologist);
		specialtyMap.put("radiologist", DoctorSpecialty.Radiologist);
		specialtyMap.put("anesthesiologist", DoctorSpecialty.Anesthesiologist);
		specialtyMap.put("dental surgeon", DoctorSpecialty.DentalSurgeon);
	}

	@PutMapping("/doctor")
	public SignupResponse doctorSignup(@RequestBody DoctorSignupRequest request)
	{
		//Create account, user and patient objects.
		//Create account
		Account account = new Account();
		account.setEmail(request.email);
		account.setUsername(request.username);
		account.setPassword(request.password);
		//Create user
		User user = new User();
		user.setFirstName(request.firstName);
		user.setLastName(request.lastName);
		user.setBirthdate(Date.valueOf(request.Birthdate));
		user.setGender(request.gender.equalsIgnoreCase("male") ? Gender.Male : Gender.Female);
		user.setAddress(request.address);
		user.setMobilePhone(request.mobile);
		user.setLandlinePhone(request.landline);
		//Create Doctor
		Doctor doctor = new Doctor();
		doctor.setTitle(titleMap.get(request.title));
		doctor.setSpecialty(specialtyMap.get(request.specialty));
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().registerDoctor(account, user, doctor);
		boolean success = msg.isEmpty();
		SignupResponse response = new SignupResponse();
		response.msg = msg;
		response.success = success;
		return response;
	}

}

class DummyRegistrar{
	public String registerPatient(Account account, User user, Patient patient)
	{
		return "";
	}
	public String registerDoctor(Account account, User user, Doctor doctor)
	{
		return "";
	}
}


class SignupRequest{
	public String email, username, firstName, lastName, password, address, landline, mobile, Birthdate;
	public int age;
	public String gender; //0 for male, 1 for female
}

class DoctorSignupRequest extends SignupRequest{
	public String specialty, title;
}

class SignupResponse{
	public String msg;
	public boolean success;
}