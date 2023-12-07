package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Doctor}
 */
@Value
public class DoctorDTO implements Serializable {
    Integer id;
    DoctorTitle title;
    DoctorSpecialty specialty;
    SystemUserDTO systemUser;
}