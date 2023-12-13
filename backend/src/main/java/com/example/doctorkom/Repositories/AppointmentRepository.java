package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.AppointmentId;
import com.example.doctorkom.Entities.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
    Appointment findByTimeSlot(TimeSlot timeSlot);
}