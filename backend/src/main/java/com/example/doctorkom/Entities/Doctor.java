package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "Doctor")
@Getter
@Setter
@ToString
@NoArgsConstructor
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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private SystemUser systemUser;

    public Doctor(DoctorTitle title, DoctorSpecialty specialty, SystemUser systemUser) {
        this.title = title;
        this.specialty = specialty;
        this.systemUser = systemUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doctor doctor = (Doctor) o;
        return id != null && Objects.equals(id, doctor.id);
    }
}