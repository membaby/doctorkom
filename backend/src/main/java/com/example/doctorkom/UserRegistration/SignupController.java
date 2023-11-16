package com.example.doctorkom.UserRegistration;

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
		boolean success = msg.isEmpty();
		SignupResponse response = new SignupResponse();
		response.msg = msg;
		response.success = success;
		return response;
	}

	@PutMapping("/doctor")
	public SignupResponse doctorSignup(@RequestBody DoctorDTO doctorDTO)
	{
		//Create doctor entity.
		Doctor doctor = DoctorDTOMapper.INSTANCE.toEntity(doctorDTO);
		//Call bussiness logic to register patient
		String msg = new DummyRegistrar().tryRegisterDoctor(doctor);
		boolean success = msg.isEmpty();
		SignupResponse response = new SignupResponse();
		response.msg = msg;
		response.success = success;
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



class SignupResponse{
	public String msg;
	public boolean success;
}