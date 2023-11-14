package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// enum DoctorTitle {
//     Professor,
//     Lecturer,
//     Consultant,
//     Specialist
// }

// enum DoctorSpecialty {
//     GeneralPractitioner,
//     Cardiologist,
//     Dermatologist,
//     Pediatrician,
//     OrthopedicSurgeon,
//     Gynecologist,
//     Ophthalmologist,
//     Neurologist,
//     Urologist,
//     ENTSpecialist,
//     Psychiatrist,
//     Oncologist,
//     Radiologist,
//     Anesthesiologist,
//     DentalSurgeon
// }

@Entity
@Table(name = "Doctor")
@Getter
@Setter
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private Integer id;

    @Column(name = "Title")
    private DoctorTitle title;

    @Column(name = "Specialty")
    private DoctorSpecialty specialty;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "UserId")
    private User user;

    public Doctor(DoctorTitle title, DoctorSpecialty specialty) {
        this.title = title;
        this.specialty = specialty;
    }
}