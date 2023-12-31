package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer>, JpaSpecificationExecutor<Patient> {
    List<Patient> findByOccupation(String firstName);
    List<Patient> findByMaritalStatus(String lastName);
    List<Patient> findByInsurance(String insurance);
}