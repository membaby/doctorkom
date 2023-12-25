package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorkom.Entities.SystemAdmin;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Integer>, JpaSpecificationExecutor<SystemAdmin> {

}
