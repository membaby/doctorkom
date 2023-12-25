package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.Gender;
import lombok.Builder;
import lombok.Value;

import java.sql.Date;

/**
 * DTO for {@link com.example.doctorkom.Entities.SystemUser}
 */
@Value
@Builder
public class SystemUserDTO {
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