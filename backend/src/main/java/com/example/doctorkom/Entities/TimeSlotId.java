package com.example.doctorkom.Entities;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
public class TimeSlotId implements Serializable {
    private Doctor doctor;
    private Clinic clinic;
    private Date date;
}
