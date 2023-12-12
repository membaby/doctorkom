package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.AppointmentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
}