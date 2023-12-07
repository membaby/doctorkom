package com.example.doctorkom.DTOs;

import lombok.Value;

import java.io.Serializable;
import java.sql.Date;

/**
 * DTO for {@link com.example.doctorkom.Entities.TimeSlot}
 */
@Value
public class TimeSlotDTO implements Serializable {
    DoctorDTO doctor;
    ClinicDTO clinic;
    Date date;
}