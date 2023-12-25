package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClinicDoctorDTO {
    String email;
    ClinicDTO clinic;
}
