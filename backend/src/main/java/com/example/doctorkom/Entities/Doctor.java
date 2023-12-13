package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Doctor")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @Column(name = "UserId")
    private Integer id;

    @Column(name = "Title")
    @Enumerated(EnumType.STRING)
    private DoctorTitle title;

    @Column(name = "Specialty")
    @Enumerated(EnumType.STRING)
    private DoctorSpecialty specialty;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private SystemUser systemUser;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<MedicalNote> medicalNotes;

    @OneToMany(mappedBy = "doctor")
    @ToString.Exclude
    private List<TimeSlot> timeSlots;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "WorksFor",
            joinColumns = @JoinColumn(name = "DoctorId"),
            inverseJoinColumns = @JoinColumn(name = "ClinicId")
    )
    @ToString.Exclude
    private List<Clinic> clinics;

    public void addMedicalNote (MedicalNote medicalNote) {
        if (medicalNotes == null) {
            medicalNotes = new ArrayList<>();
        }

        medicalNotes.add(medicalNote);
        medicalNote.setDoctor(this);
    }

    void removeMedicalNote (MedicalNote medicalNote) {
        if (medicalNotes != null) {
            medicalNotes.remove(medicalNote);
            medicalNote.setDoctor(null);
        }
    }

    public void addTimeSlot (TimeSlot timeSlot) {
        if (timeSlots == null) {
            timeSlots = new ArrayList<>();
        }

        timeSlots.add(timeSlot);
        timeSlot.setDoctor(this);
    }

    void removeTimeSlot (TimeSlot timeSlot) {
        if (timeSlots != null) {
            timeSlots.remove(timeSlot);
            timeSlot.setDoctor(null);
        }
    }

    public void addClinic (Clinic clinic) {
        if (clinics == null) {
            clinics = new ArrayList<>();
        }

        clinics.add(clinic);
        clinic.getDoctors().add(this);
    }

    void removeClinic (Clinic clinic) {
        if (clinics != null) {
            clinics.remove(clinic);
            clinic.getDoctors().remove(this);
        }
    }
}