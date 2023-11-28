package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClinicRepository extends JpaRepository<Clinic, Integer> {
    Clinic findByEmail(String email);
    Clinic findById(int id);
    Clinic findByName(String name);
    void deleteByEmail(String mail);
    void deleteByName(String name);

    void deleteById(int id);
}
