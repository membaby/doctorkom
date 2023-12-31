package com.example.doctorkom.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class AppointmentDTO {
    TimeSlotDTO timeSlot;
    PatientDTO patient;
}
