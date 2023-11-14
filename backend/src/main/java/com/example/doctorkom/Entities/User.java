package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;



@Entity
@Table(name = "User")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AccountId")
    private Integer id;

    @Column(name = "FirstName")
    private String firstName;

    @Column(name = "LastName")
    private String lastName;

    @Column(name = "Birthdate")
    private Date birthdate;

    @Column(name = "Gender")
    private Gender gender;

    @Column(name = "Address")
    private String address;

    @Column(name = "MobilePhone")
    private String mobilePhone;

    @Column(name = "LandlinePhone")
    private String landlinePhone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AccountId")
    private Account account;

    public User(Account account, String firstName, String lastName) {
        this.account = account;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}