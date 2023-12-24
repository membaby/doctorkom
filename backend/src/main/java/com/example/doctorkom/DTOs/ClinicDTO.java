package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Clinic}
 */
@Value
@Builder
public class ClinicDTO implements Serializable {
    Integer id;
    String name;
    String address;
    String email;
    String mobilePhone;
    String landlinePhone;
    ClinicAdminDTO admin;
}