package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@ToString
@NoArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private SystemUser systemUser;

    public Patient(String occupation, String maritalStatus, String insurance, SystemUser systemUser) {
        this.occupation = occupation;
        this.maritalStatus = maritalStatus;
        this.insurance = insurance;
        this.systemUser = systemUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Patient patient = (Patient) o;
        return id != null && Objects.equals(id, patient.id);
    }
}