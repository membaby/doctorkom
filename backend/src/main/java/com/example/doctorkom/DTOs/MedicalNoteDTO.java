package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;

/**
 * DTO for {@link com.example.doctorkom.Entities.MedicalNote}
 */
@Value
@Builder
public class MedicalNoteDTO {
    Date date;
    String diagnosis;
    String investigations;
    String prescription;
    PatientDTO patient;
    DoctorDTO doctor;
}