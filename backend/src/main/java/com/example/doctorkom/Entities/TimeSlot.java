package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "TimeSlot")
@IdClass(TimeSlotId.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id
    @Column(name = "Date")
    private Date date;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "ClinicId")
    private Clinic clinic;

    @Transient
    @Column(name = "weekday", insertable = false, updatable = false)
    private String weekday;
}