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
		Clinic clinic=new Clinic("sz","sm","sm","sm","sm");
//		clinicRepository.save(clinic);
//		clinicService.createClinic(clinic);
		clinicService.removeClinic(clinic);
		System.out.print("deleted semo");

	};
}
}
