package com.example.doctorkom.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@IdClass(TimeSlotId.class)
@Table(name = "TimeSlot")
@Getter
@Setter
@Builder
@ToString
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TimeSlot that)) return false;
        return getDoctor().equals(that.getDoctor()) && getClinic().equals(that.getClinic()) && getDate().equals(that.getDate());
    }
}

