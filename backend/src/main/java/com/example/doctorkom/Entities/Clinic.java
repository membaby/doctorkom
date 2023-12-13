package com.example.doctorkom.Entities;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "clinic")
    @ToString.Exclude
    private List<TimeSlot> timeSlots;
    //set fees in works for to zero for now for all doctors
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "WorksFor",
            joinColumns = @JoinColumn(name = "ClinicId"),
            inverseJoinColumns = @JoinColumn(name = "DoctorId")

    )
    @ToString.Exclude
    private List<Doctor> doctors;

    public void addTimeSlot (TimeSlot timeSlot) {
        if (timeSlots == null) {
            timeSlots = new ArrayList<>();
        }

        timeSlots.add(timeSlot);
        timeSlot.setClinic(this);
    }

    void removeTimeSlot (TimeSlot timeSlot) {
        if (timeSlots != null) {
            timeSlots.remove(timeSlot);
            timeSlot.setDoctor(null);
        }
    }

    public void addDoctor (Doctor doctor) {
        if (doctors == null) {
            doctors = new ArrayList<>();
        }

        doctors.add(doctor);
        doctor.getClinics().add(this);
    }

    void removeDoctor (Doctor doctor) {
        if (doctors != null) {
            doctors.remove(doctor);
            doctor.getClinics().remove(this);
        }
    }
}