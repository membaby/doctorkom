package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Optional<List<Doctor>> findByTitle(DoctorTitle title);
    Optional<List<Doctor>> findBySpecialty(DoctorSpecialty specialty);
}