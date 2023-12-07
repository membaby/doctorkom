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
    Optional<List<SystemUser>> findByFirstName(String firstName);
    Optional<List<SystemUser>> findByLastName(String lastName);
    Optional<List<SystemUser>> findByBirthdate(Date birthdate);
    Optional<List<SystemUser>> findByGender(Gender gender);
    Optional<List<SystemUser>> findByAddress(String address);
    Optional<List<SystemUser>> findByLandlinePhone(String landlinePhone);
    Optional<SystemUser> findByMobilePhone(String mobilePhone);
}