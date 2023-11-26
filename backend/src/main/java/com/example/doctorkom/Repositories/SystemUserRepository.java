package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Gender;
import com.example.doctorkom.Entities.SystemUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface SystemUserRepository extends JpaRepository<SystemUser, Integer> {
    List<SystemUser> findByFirstName(String firstName);
    List<SystemUser> findByLastName(String lastName);
    List<SystemUser> findByBirthdate(Date birthdate);
    List<SystemUser> findByGender(Gender gender);
    List<SystemUser> findByAddress(String address);
    List<SystemUser> findByLandlinePhone(String landlinePhone);
    SystemUser findByMobilePhone(String mobilePhone);
}