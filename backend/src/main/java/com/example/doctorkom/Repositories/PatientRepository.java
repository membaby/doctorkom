package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Integer> {
}