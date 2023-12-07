package com.example.doctorkom.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.doctorkom.Entities.SystemAdmin;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAdminRepository extends JpaRepository<SystemAdmin, Integer>{

}
