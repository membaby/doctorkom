package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Gender;
import com.example.doctorkom.Entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface SystemUserRepository extends JpaRepository<SystemUser, Integer>, JpaSpecificationExecutor<SystemUser> {
    List<SystemUser> findByFirstName(String firstName);
    List<SystemUser> findByLastName(String lastName);
    List<SystemUser> findByBirthdate(Date birthdate);
    List<SystemUser> findByGender(Gender gender);
    List<SystemUser> findByAddress(String address);
    List<SystemUser> findByLandlinePhone(String landlinePhone);
    Optional<SystemUser> findByMobilePhone(String mobilePhone);
}