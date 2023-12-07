package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.Hibernate;

import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "SystemUser")
@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class SystemUser {
    @Id
    @Column(name = "AccountId")
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Birthdate")
    private Date birthdate;

    @Column(name = "Gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "Address")
    private String address;

    @Column(name = "MobilePhone")
    private String mobilePhone;

    @Column(name = "LandlinePhone")
    private String landlinePhone;

    @MapsId
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        SystemUser systemUser = (SystemUser) o;
        return id != null && Objects.equals(id, systemUser.id);
    }
}