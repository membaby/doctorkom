package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.example.doctorkom.Entities.Patient}
 */
@Value
@Builder
public class PatientDTO {
    Integer id;
    String occupation;
    String maritalStatus;
    String insurance;
    SystemUserDTO systemUser;
}
