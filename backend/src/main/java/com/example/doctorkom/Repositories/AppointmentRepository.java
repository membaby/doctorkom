package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
    Appointment findByTimeSlot(TimeSlot timeSlot);

    Page<Appointment> findAllByPatient(Patient patient, Pageable pageable);

    Page<Appointment> findAllByTimeSlotDoctor(Doctor doctor, Pageable pageable);
}