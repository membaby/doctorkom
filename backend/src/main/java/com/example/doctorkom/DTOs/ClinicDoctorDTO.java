package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

@Data
@Builder
public class ClinicDoctorDTO implements Serializable {
    String email;
    ClinicDTO clinic;
}
