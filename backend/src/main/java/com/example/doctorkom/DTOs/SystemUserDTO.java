package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.Gender;
import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.example.doctorkom.Entities.SystemUser}
 */
@Value
public class SystemUserDTO implements Serializable {
    Integer id;
    String firstName;
    String lastName;
    Date birthdate;
    Gender gender;
    String address;
    String mobilePhone;
    String landlinePhone;
    AccountDTO account;
}