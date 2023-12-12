package com.example.doctorkom.Entities;

import lombok.*;

import java.io.Serializable;
import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeSlotId implements Serializable {
    private Clinic clinic;
    private Doctor doctor;
    private Date date;
}
