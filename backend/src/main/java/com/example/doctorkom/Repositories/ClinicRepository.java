package com.example.doctorkom.Repositories;

import java.util.List;
import java.util.Optional;

import com.example.doctorkom.Entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClinicRepository extends JpaRepository<Clinic, Integer>{
    Optional<List<Clinic>> findByName(String name);
}
