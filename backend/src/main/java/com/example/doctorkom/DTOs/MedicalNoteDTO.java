package com.example.doctorkom.DTOs;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.example.doctorkom.Entities.MedicalNote}
 */
@Value
public class MedicalNoteDTO implements Serializable {
    Date date;
    String diagnosis;
    String investigations;
    String prescription;
    PatientDTO patient;
    DoctorDTO doctor;
}