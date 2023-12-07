package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Optional<List<Patient>> findByOccupation(String firstName);
    Optional<List<Patient>> findByMaritalStatus(String lastName);
    Optional<List<Patient>> findByInsurance(String insurance);
}