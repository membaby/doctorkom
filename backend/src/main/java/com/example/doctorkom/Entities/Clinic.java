package com.example.doctorkom.Entities;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Clinic")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Clinic {
    @Id
    @Column(name = "ClinicId")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email")
    private String email;

    @Column(name = "MobilePhone")
    private String mobilePhone;

    @Column(name = "LandlinePhone")
    private String landlinePhone;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ClinicId")
    private ClinicAdmin admin;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Clinic clinic = (Clinic) o;
        return id != null && Objects.equals(id, clinic.id);
    }
}