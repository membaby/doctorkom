package com.example.doctorkom;

import com.example.doctorkom.Repositories.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class DoctorkomApplication {
	
	// @Autowired
	// private ClinicService clinicService;

	public static void main(String[] args) {
		SpringApplication.run(DoctorkomApplication.class, args);
	}

	// @Bean
	// @Autowired
	// public CommandLineRunner commandLineRunner (ClinicRepository clinicRepository) {
	// // 	return runner -> {
	// // 		Clinic clinic=new Clinic("sz","sm","sm","sm","sm");
	// // //		clinicRepository.save(clinic);
	// // //		clinicService.createClinic(clinic);
	// // 		clinicService.removeClinic(clinic);
	// // 		System.out.print("deleted semo");
	// // 	};
	// }

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner (AccountRepository accountRepository, SystemUserRepository systemUserRepository, VerificationRepository verificationRepository,
												PatientRepository patientRepository, DoctorRepository doctorRepository) {
		return runner -> {
//			String dateTimeString = "2023-11-27 09:30:00";
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//			LocalDateTime localDateTime = LocalDateTime.parse(dateTimeString, formatter);
//
//			Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.DOCTOR);
//			Verification verification = new Verification("ABC123", localDateTime, account);
//			SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
//			Patient patient = new Patient("BOBA", systemUser);
//
//			accountRepository.save(account);
//			verification.setId(account.getId());
//			systemUser.setId(account.getId());
//			verificationRepository.save(verification);
//			systemUserRepository.save(systemUser);
//			patient.setId(systemUser.getId());
//			System.out.println(patient);
//			patientRepository.save(patient);
//
//			// Then
//			Verification queriedVerification = verificationRepository.findById(verification.getId()).orElse(null);
//			System.out.println(queriedVerification);
		};
	}
}
