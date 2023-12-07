package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    Optional<List<Clinic>> findByName(String name);
    Optional<Clinic> findByEmail(String email);
    void deleteByEmail(String mail);
}
