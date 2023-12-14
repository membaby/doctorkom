package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

@Value
@Builder
public class ClinicDoctorDTO implements Serializable {
    String email;
    ClinicDTO clinic;
}
