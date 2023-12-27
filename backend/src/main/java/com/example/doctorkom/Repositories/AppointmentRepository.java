package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.AppointmentId;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.TimeSlot;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AppointmentRepository extends JpaRepository<Appointment, AppointmentId> {
    Appointment findByTimeSlot(TimeSlot timeSlot);

    Page<Appointment> findAllByPatient(Patient patient, Pageable pageable);

    Page<Appointment> findAllByTimeSlotDoctor(Doctor doctor, Pageable pageable);
}