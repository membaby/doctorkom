package com.example.doctorkom;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DoctorkomApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorkomApplication.class, args);
	}

	@Bean
	@Autowired
	public CommandLineRunner commandLineRunner (AccountRepository accountRepository) {
		return runner -> {
//			comment: Create new account and user and attach it to a patient and by cascading adding a user and an account to db

			Account account = new Account("Mostafa_Galal", "mostafam.galal82@gmail.com", "galal123", Role.PATIENT);

		};
	}
}
