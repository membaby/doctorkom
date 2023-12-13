package com.example.doctorkom.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentId implements java.io.Serializable {
    private TimeSlot timeSlot;
    private Patient patient;
}
