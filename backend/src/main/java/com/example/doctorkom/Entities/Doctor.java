package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
}