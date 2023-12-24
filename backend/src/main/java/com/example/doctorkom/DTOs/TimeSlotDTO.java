package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.sql.Date;
import java.sql.Time;

/**
 * DTO for {@link com.example.doctorkom.Entities.TimeSlot}
 */
@Value
@Builder
public class TimeSlotDTO {
    DoctorDTO doctor;
    ClinicDTO clinic;
    Date date;
    Time startTime;
    Time endTime;
    Boolean reserved;
}