package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;
import org.hibernate.proxy.HibernateProxy;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Patient")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    @Id
    @Column(name = "UserId")
    private Integer id;

    @Column(name = "Occupation")
    private String occupation;

    @Column(name = "MaritalStatus")
    private String maritalStatus;

    @Column(name = "Insurance")
    private String insurance;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private SystemUser systemUser;

    @OneToMany(mappedBy = "patient")
    @ToString.Exclude
    private List<Appointment> appointments;

    public void addAppointment (Appointment appointment) {
        if (appointments == null) {
            appointments = new ArrayList<>();
        }

        appointments.add(appointment);
        appointment.setPatient(this);
    }

    public void removeAppointment (Appointment appointment) {
        if (appointments != null) {
            appointments.remove(appointment);
            appointment.setPatient(null);
        }
    }

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<MedicalNote> medicalNotes;
  
    public void addMedicalNote (MedicalNote medicalNote) {
        if (medicalNotes == null) {
            medicalNotes = new ArrayList<>();
        }

        medicalNotes.add(medicalNote);
        medicalNote.setPatient(this);
    }

    public void removeMedicalNote (MedicalNote medicalNote) {
        if (medicalNotes != null) {
            medicalNotes.remove(medicalNote);
            medicalNote.setPatient(null);
        }
    }
}