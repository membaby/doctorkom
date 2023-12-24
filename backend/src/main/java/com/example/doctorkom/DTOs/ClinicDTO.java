package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.example.doctorkom.Entities.Clinic}
 */
@Value
@Builder
public class ClinicDTO {
    Integer id;
    String name;
    String address;
    String email;
    String mobilePhone;
    String landlinePhone;
    ClinicAdminDTO admin;
}