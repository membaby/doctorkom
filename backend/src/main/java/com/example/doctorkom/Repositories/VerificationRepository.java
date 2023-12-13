package com.example.doctorkom.Repositories;


import com.example.doctorkom.Entities.Verification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface VerificationRepository extends JpaRepository<Verification, Integer> {

}