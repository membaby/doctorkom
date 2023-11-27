package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOMappers.DoctorDTOMapper;
import com.example.doctorkom.DTOMappers.PatientDTOMapper;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Doctor;

@RestController
@RequestMapping("/signup")
public class SignupController {
	
	@PutMapping("/patient")
	public SignupResponse patientSignup(@RequestBody PatientDTO patientDTO) {
		//Create Patient entity
		Patient patient = PatientDTOMapper.INSTANCE.toEntity(patientDTO);
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().tryRegisterPatient(patient);
		SignupResponse response = new SignupResponse(msg, msg.isEmpty());
		return response;
	}

	@PutMapping("/doctor")
	public SignupResponse doctorSignup(@RequestBody DoctorDTO doctorDTO)
	{
		//Create doctor entity.
		Doctor doctor = DoctorDTOMapper.INSTANCE.toEntity(doctorDTO);
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

