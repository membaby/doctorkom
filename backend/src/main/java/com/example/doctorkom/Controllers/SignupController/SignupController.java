package com.example.doctorkom.Controllers.SignupController;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOMappers.PatientMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;
import com.example.doctorkom.Entities.Doctor;

@RestController
@RequestMapping("/registration")
public class SignupController {

	@Autowired
	PatientMapper patientMapper;
	@Autowired
	DoctorMapper doctorMapper;
	@Autowired
	RegistrationService registrationService;
	
	@PostMapping("/patient")
	public BoolMessage patientSignup(@RequestBody PatientDTO patientDTO) {
		System.out.println("trying to signup");
		//Create Patient entity
		Patient patient = patientMapper.toEntity(patientDTO);
		//Call bussiness logic to register patient
		String msg = registrationService.registerPatient(patient);
		BoolMessage response = new BoolMessage(msg, msg.isEmpty());
		return response;
	}

	@PostMapping("/doctor")
	public BoolMessage doctorSignup(@RequestBody DoctorDTO doctorDTO)
	{
		//Create doctor entity.
		Doctor doctor = doctorMapper.toEntity(doctorDTO);
		//Call bussiness logic to register patient
		String msg = registrationService.registerDoctor(doctor);
		BoolMessage response = new BoolMessage(msg, msg.isEmpty());
		return response;
	}
}


