package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.sql.Date;
import java.util.Objects;

@Entity
@IdClass(TimeSlotId.class)
@Table(name = "TimeSlot")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlot {
    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "DoctorId")
    private Doctor doctor;

    @Id
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH})
    @JoinColumn(name = "ClinicId")
    private Clinic clinic;

    @Id
    @Column(name = "Date")
    private Date date;

    @Transient
    @Column(name = "weekday", insertable = false, updatable = false)
    private String weekday;
}

