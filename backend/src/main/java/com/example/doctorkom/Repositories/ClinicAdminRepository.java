package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.ClinicAdmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClinicAdminRepository extends JpaRepository<ClinicAdmin, Integer> {

}
