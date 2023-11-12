package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Patient")
@Getter
@Setter
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
    private User user;

    public Patient(User user, String insurance) {
        this.user = user;
        this.insurance = insurance;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", maritalStatus='" + maritalStatus + '\'' +
                ", occupation='" + occupation + '\'' +
                ", insurance='" + insurance + '\'' +
                ", user=" + user +
                '}';
    }
}