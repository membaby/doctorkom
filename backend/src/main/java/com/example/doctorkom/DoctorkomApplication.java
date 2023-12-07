package com.example.doctorkom;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Repositories.*;

import com.example.doctorkom.EntitySearch.SearchSpecification;
import com.example.doctorkom.EntitySearch.SearchFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class DoctorkomApplication {
	public static void main(String[] args) {
		SpringApplication.run(DoctorkomApplication.class, args);
	}

//	@Bean
//	@Autowired
//	public CommandLineRunner commandLineRunner (DoctorRepository doctorRepository, SearchSpecification<Doctor> doctorSearchSpecification, ClinicRepository clinicRepository, SearchSpecification<Clinic> clinicSearchSpecification) {
//		return runner -> {
//			Map<String, List<String>> values = Map.of(
//					"specialty", List.of("PEDIATRICIAN", "GENERAL_PRACTITIONER"),
//					"title", List.of("LECTURER", "PROFESSOR", "CONSULTANT"),
//					"id", List.of("1", "2", "3", "4", "5")
//			);
//
//			List<Specification<Doctor>> entitySpecification = new ArrayList<>();
//			List<Specification<Doctor>> attributeSpecifications = new ArrayList<>();
//			for (Map.Entry<String, List<String>> entry : values.entrySet()) {
//				String key = entry.getKey();
//				for (String value : entry.getValue()) {
//					SearchFilter searchFilter = SearchFilter.builder().field(key).operator(SearchFilter.QueryOperator.EQUALS).value(value).build();
//					attributeSpecifications.add(doctorSearchSpecification.createSpecification(searchFilter));
//				}
//				entitySpecification.add(doctorSearchSpecification.union(attributeSpecifications));
//				attributeSpecifications.clear();
//			}
//			List<Doctor> doctors = doctorRepository.findAll(doctorSearchSpecification.intersection(entitySpecification));
//
//			for (Doctor doctor : doctors) {
//				System.out.println(doctor);
//			}
//
//			values = Map.of(
//					"name", List.of("Clinic 93", "Clinic 94")
//			);
//
//			List<Specification<Clinic>> clinicSpecifications = new ArrayList<>();
//			List<Specification<Clinic>> clinicAttributeSpecifications = new ArrayList<>();
//			for (Map.Entry<String, List<String>> entry : values.entrySet()) {
//				String key = entry.getKey();
//				for (String value : entry.getValue()) {
//					SearchFilter searchFilter = SearchFilter.builder().field(key).operator(SearchFilter.QueryOperator.LIKE).value(value).build();
//					clinicAttributeSpecifications.add(clinicSearchSpecification.createSpecification(searchFilter));
//				}
//				clinicSpecifications.add(clinicSearchSpecification.union(clinicAttributeSpecifications));
//				clinicAttributeSpecifications.clear();
//			}
//			List<Clinic> clinics = clinicRepository.findAll(clinicSearchSpecification.intersection(clinicSpecifications));
//
//			for (Clinic clinic : clinics) {
//				System.out.println(clinic);
//			}
//		};
//	}
}
