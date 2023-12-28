package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.AppointmentMapper;
import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Exceptions.AppointmentExceptions.AppointmentNotFoundException;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import com.example.doctorkom.Exceptions.PatientExceptions.PatientNotFoundException;
import com.example.doctorkom.Repositories.AppointmentRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        if (patientRepository.findById(patientId).isEmpty())
            throw new PatientNotFoundException();
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        Patient patient = patientRepository.findById(patientId).get();
        Page<Appointment> appointments = appointmentRepository.findAllByPatient(patient, pageable);
        return appointments.map(appointmentMapper::toDto);
    }

    public List<AppointmentDTO> getDoctorAppointments(int doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty())
            throw new DoctorNotFoundException();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        List<Appointment> appointments = appointmentRepository.findAllByTimeSlotDoctor(doctor);
        return appointments.stream().map(appointmentMapper::toDto).collect(Collectors.toList());
    }

    public void deleteAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = appointmentMapper.toEntity(appointmentDTO);
        if (appointmentRepository.findById(appointment.getId()).isEmpty())
            throw new AppointmentNotFoundException();
        appointmentRepository.deleteById(appointment.getId());
    }
}
