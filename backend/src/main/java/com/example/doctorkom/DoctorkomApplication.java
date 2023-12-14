package com.example.doctorkom;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

import static java.lang.Thread.sleep;


@SpringBootApplication
public class DoctorkomApplication {

	// @Autowired
	// private ClinicService clinicService;

	public static void main(String[] args) {
		SpringApplication.run(DoctorkomApplication.class, args);
	}

//	@Bean
//	@Autowired
//	public CommandLineRunner commandLineRunner (AccountRepository accountRepository, SystemUserRepository systemUserRepository, VerificationRepository verificationRepository,
//												PatientRepository patientRepository, DoctorRepository doctorRepository, MedicalNoteRepository medicalNoteRepository) {
//		return runner -> {
//			// Given
//			Account patientAccount = Account.builder().
//					email("johnsmith123@lol.com").
//					username("JohnSmith1").
//					password("JohnyJohny123").
//					role(Role.PATIENT).
//					build();
//
//			SystemUser patientSystemUser = SystemUser.builder().
//					firstName("John").
//					lastName("Smith").
//					birthdate(Date.valueOf("1985-11-14")).
//					gender(Gender.MALE).
//					address("221B Baker Street").
//					mobilePhone("(555) 555-5555").
//					landlinePhone("(555) 123-4567").
//					account(patientAccount).
//					build();
//
//			Patient patient = Patient.builder().
//					occupation("Engineer").
//					maritalStatus("Single").
//					insurance("BOBA").
//					systemUser(patientSystemUser).
//					build();
//
//			patientRepository.save(patient);
//
//			Account doctorAccount = Account.builder().
//					email("drsmith@hospital.com").
//					username("DrSmith1").
//					password("Medical123").
//					role(Role.DOCTOR).
//					build();
//
//			SystemUser doctorSystemUser = SystemUser.builder().
//					firstName("Smith").
//					lastName("Health").
//					birthdate(Date.valueOf("1976-10-30")).
//					gender(Gender.MALE).
//					address("123 Main Street").
//					mobilePhone("(666) 666-6666").
//					landlinePhone("(555) 765-4321").
//					account(doctorAccount).
//					build();
//
//			Doctor doctor = Doctor.builder().
//					title(DoctorTitle.PROFESSOR).
//					specialty(DoctorSpecialty.ONCOLOGIST).
//					systemUser(doctorSystemUser).
//					build();
//
//			doctorRepository.save(doctor);
//
//			MedicalNote medicalNote = MedicalNote.builder().
//					date(Date.valueOf("2023-04-01")).
//					patient(patient).
//					doctor(doctor).
//					build();
//
//			medicalNoteRepository.save(medicalNote);
//
//			patient.addMedicalNote(medicalNote);
//
//			patientRepository.save(patient);
//			doctorRepository.save(doctor);
//			medicalNote.setPatient(patient);
//			medicalNote.setDoctor(doctor);
//			medicalNoteRepository.save(medicalNote);
//
//			sleep(10000);
//			// When
//			medicalNoteRepository.deleteByDoctorId(doctor.getId());
//
//			// Then
//			System.out.println(medicalNoteRepository.findByDoctorId(doctor.getId()).isEmpty());
//		};
//	}
}
