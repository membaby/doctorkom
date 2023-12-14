package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Patient}
 */
@Value
@Builder
public class PatientDTO implements Serializable {
    Integer id;
    String occupation;
    String maritalStatus;
    String insurance;
    SystemUserDTO systemUser;
}