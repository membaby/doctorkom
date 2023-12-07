package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Doctor")
@Getter
@Setter
@Builder
@ToString
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

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "WorksFor",
            joinColumns = @JoinColumn(name = "DoctorId"),
            inverseJoinColumns = @JoinColumn(name = "ClinicId")
    )
    private List<Clinic> clinics;

    public void addClinic (Clinic clinic) {
        if (clinics == null) {
            clinics = new ArrayList<>();
        }

        clinics.add(clinic);
        clinic.getDoctors().add(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Doctor doctor = (Doctor) o;
        return id != null && Objects.equals(id, doctor.id);
    }
}