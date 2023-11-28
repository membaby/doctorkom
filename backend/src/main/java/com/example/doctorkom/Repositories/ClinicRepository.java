package com.example.doctorkom.Repositories;

import java.util.List;

import com.example.doctorkom.Entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClinicRepository extends JpaRepository<Clinic, Integer>{
    
    List<Clinic> findByName(String name);
}
