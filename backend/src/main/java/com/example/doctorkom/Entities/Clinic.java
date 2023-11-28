package com.example.doctorkom.Entities;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import java.util.Objects;


@Entity
@Table(name = "Clinic")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Clinic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Email")
    private String email;

    @Column(name = "Name")
    private String name;

    @Column(name = "Address")
    private String address;


    @Column(name = "Phone")
    private String phone;

    @Column(name = "Landline")
    private String landline;


    public Clinic(String email, String name, String address, String phone,String landline) {
        this.email = email;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.landline=landline;


    }


    public String getEmail() {
        return email;
    }
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
    public int getId() {
        return id;
    }
    public String getPhone() {
        return phone;
    }

    public String getLandline() {
        return landline;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Clinic clinic = (Clinic) o;
        return id != null && Objects.equals(id, clinic.id);
    }

}