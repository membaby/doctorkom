package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@Entity
@Table(name = "ClinicAdmin")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ClinicAdmin {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        ClinicAdmin clinicAdmin = (ClinicAdmin) o;
        return id != null && Objects.equals(id, clinicAdmin.id);
    }
}
