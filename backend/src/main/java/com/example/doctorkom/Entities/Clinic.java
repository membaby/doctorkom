package com.example.doctorkom.Entities;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@Entity
@Table(name = "Clinic")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Clinic {
    @Id
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;

    @Column(name = "Email")
    private String email;


    public Clinic(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Clinic)) return false;
        Clinic clinic = (Clinic) o;
        return Objects.equals(id, clinic.id);
    }
}
