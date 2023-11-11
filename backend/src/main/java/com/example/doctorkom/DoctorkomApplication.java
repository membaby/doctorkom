package com.example.doctorkom;

import com.example.doctorkom.DAOs.AccountDAO;
import com.example.doctorkom.DAOs.PatientDAO;
import com.example.doctorkom.DAOs.UserDAO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.User;
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
	public CommandLineRunner commandLineRunner (PatientDAO patientDAO) {
		return runner -> {
//			comment: Create new account and user and attach it to a patient and by cascading adding a user and an account to db
			Account account = new Account("mostafam.galal82@gmail.com", "Mostafa_Galal", "galal123");
			User user = new User(account, "mostafa", "galal");
			Patient patient = new Patient(user, "BOBA");

			System.out.println(patient);
			System.out.println("Now inserting patient");
			patientDAO.insert(patient);
			System.out.println("Inserted!!");

			Thread.sleep(10000);
			System.out.println("Now deleting inserted patient");
			patientDAO.delete(patient.getId());
			System.out.println("Deleted!!");
		};
	}
}
