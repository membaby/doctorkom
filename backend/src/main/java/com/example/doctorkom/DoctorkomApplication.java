package com.example.doctorkom;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Services.ClinicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.sql.Date;

import static java.time.ZoneOffset.UTC;

@SpringBootApplication
public class DoctorkomApplication {

	public static void main(String[] args) {
		SpringApplication.run(DoctorkomApplication.class, args);
	}
	private final ClinicService clinicService;
	@Autowired
	public DoctorkomApplication(ClinicService clinicService) {
		this.clinicService = clinicService;
	}
@Bean
@Autowired
public CommandLineRunner commandLineRunner (ClinicRepository clinicRepository) {
	return runner -> {
		Clinic clinic=new Clinic("s3","s3","sm","3m","sm");

//		clinicRepository.save(clinic);
		clinicService.createClinic(clinic);
		Thread.sleep(100);
		clinicService.removeClinic(clinic);

	};
}
}
