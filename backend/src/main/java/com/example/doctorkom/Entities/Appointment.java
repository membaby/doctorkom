package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.sql.Time;

@Entity
@Table(name = "Appointment")
@IdClass(AppointmentId.class)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @MapsId
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumns({
            @JoinColumn(name = "ClinicId", referencedColumnName = "ClinicId"),
            @JoinColumn(name = "DoctorId", referencedColumnName = "DoctorId"),
            @JoinColumn(name = "Date", referencedColumnName = "Date"),
            @JoinColumn(name = "StartTime", referencedColumnName = "StartTime"),
            @JoinColumn(name = "EndTime", referencedColumnName = "EndTime")
    })
    private TimeSlot timeSlot;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "PatientId")
    private Patient patient;

    public AppointmentId getId() {
        return new AppointmentId(timeSlot, patient);
    }
}