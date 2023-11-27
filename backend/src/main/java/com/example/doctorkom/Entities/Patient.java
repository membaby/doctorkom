package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Patient")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer id;

    @Column(name = "MaritalStatus")
    private String maritalStatus;

    @Column(name = "Occupation")
    private String occupation;

    @Column(name = "Insurance")
    private String insurance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private SystemUser systemUser;

    public Patient(SystemUser systemUser, String insurance) {
        this.systemUser = systemUser;
        this.insurance = insurance;
    }
}