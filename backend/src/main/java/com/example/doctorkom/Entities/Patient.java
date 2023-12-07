package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.Objects;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@Builder
@ToString
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

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL)
    private java.util.List<MedicalNote> medicalNotes;

    public void addMedicalNote (MedicalNote medicalNote) {
        if (medicalNotes == null) {
            medicalNotes = new ArrayList<>();
        }

        medicalNotes.add(medicalNote);
        medicalNote.setPatient(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;
        return id != null && Objects.equals(id, patient.id);
    }
}