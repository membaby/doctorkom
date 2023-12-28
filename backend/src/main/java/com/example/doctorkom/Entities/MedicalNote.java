package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "MedicalNote")
@IdClass(MedicalNoteId.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MedicalNote {
    @Id
    @Column(name = "Date")
    private Date date;

    @Column(name = "Diagnosis")
    private String diagnosis;

    @Column(name = "Investigations")
    private String investigations;

    @Column(name = "Prescription")
    private String prescription;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "PatientId")
    private Patient patient;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;

    public MedicalNoteId getId() {
        return new MedicalNoteId(patient, doctor, date);
    }
    public void setId(MedicalNoteId id) {
        this.patient = id.getPatient();
        this.doctor = id.getDoctor();
        this.date = id.getDate();
    }
}
