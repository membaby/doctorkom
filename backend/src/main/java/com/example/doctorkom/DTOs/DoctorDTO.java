package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.example.doctorkom.Entities.Doctor}
 */
@Value
@Builder
public class DoctorDTO {
    Integer id;
    DoctorTitle title;
    DoctorSpecialty specialty;
    SystemUserDTO systemUser;
}