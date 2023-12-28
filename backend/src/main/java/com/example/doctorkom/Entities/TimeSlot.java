package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.sql.Time;

@Entity
@IdClass(TimeSlotId.class)
@Table(name = "TimeSlot")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id
    @Column(name = "Date")
    private Date date;

    @Id
    @Column(name = "StartTime")
    private Time startTime;

    @Id
    @Column(name = "EndTime")
    private Time endTime;

    @Column(name = "Reserved")
    private Boolean reserved;

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

    public TimeSlotId getId () {
        return new TimeSlotId(clinic, doctor, date, startTime, endTime);
    }
}
