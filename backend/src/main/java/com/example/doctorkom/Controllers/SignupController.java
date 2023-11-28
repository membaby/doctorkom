package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOMappers.PatientMapper;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Doctor;

@RestController
@RequestMapping("/registration")
public class SignupController {

	@Autowired
	PatientMapper patientMapper;

	@Autowired
	DoctorMapper doctorMapper;
	
	@PutMapping("/patient")
	public SignupResponse patientSignup(@RequestBody PatientDTO patientDTO) {
		//Create Patient entity
		Patient patient = patientMapper.toEntity(patientDTO);
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().tryRegisterPatient(patient);
		SignupResponse response = new SignupResponse(msg, msg.isEmpty());
		return response;
	}

	@PutMapping("/doctor")
	public SignupResponse doctorSignup(@RequestBody DoctorDTO doctorDTO)
	{
		//Create doctor entity.
		Doctor doctor = doctorMapper.toEntity(doctorDTO);
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().tryRegisterDoctor(doctor);
		SignupResponse response = new SignupResponse(msg, msg.isEmpty());
		return response;
	}

}

class DummyRegistrar{
	public String tryRegisterPatient(Patient patient)
	{
		return "";
	}
	public String tryRegisterDoctor(Doctor doctor)
	{
		return "";
	}
}

