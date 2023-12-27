package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.AppointmentMapper;
import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Repositories.AppointmentRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class AppointmentService {
    private static final int PAGE_SIZE = 10;
    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final AppointmentMapper appointmentMapper;

    @Autowired
    public AppointmentService(AppointmentRepository appointmentRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, AppointmentMapper appointmentMapper) {
        this.appointmentRepository = appointmentRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.appointmentMapper = appointmentMapper;
    }

    public Page<AppointmentDTO> getPatientAppointments(int patientId, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        if (patientRepository.findById(patientId).isPresent()) {
            Patient patient = patientRepository.findById(patientId).get();
            Page<Appointment> appointments = appointmentRepository.findAllByPatient(patient, pageable);
            return appointments.map(appointmentMapper::toDto);
        }
        return null;
    }

    public Page<AppointmentDTO> getDoctorAppointments(int doctorId, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        if (doctorRepository.findById(doctorId).isPresent()) {
            Doctor doctor = doctorRepository.findById(doctorId).get();
            Page<Appointment> appointments = appointmentRepository.findAllByTimeSlotDoctor(doctor, pageable);
            return appointments.map(appointmentMapper::toDto);
        }
        return null;
    }
}
