package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Doctor")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Doctor(DoctorTitle title, DoctorSpecialty specialty) {
        this.title = title;
        this.specialty = specialty;
    }
}