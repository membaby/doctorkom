package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
    Appointment findByTimeSlot(TimeSlot timeSlot);
    List<Appointment> findAllByTimeSlotClinic(Clinic clinic);

    Page<Appointment> findAllByPatient(Patient patient, Pageable pageable);

    List<Appointment> findAllByTimeSlotDoctor(Doctor doctor);
}