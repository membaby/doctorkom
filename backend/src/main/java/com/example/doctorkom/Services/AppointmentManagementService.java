package com.example.doctorkom.Services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Entities.TimeSlotId;
import com.example.doctorkom.Repositories.AppointmentRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Repositories.TimeSlotRepository;
import java.util.Optional;

@Service
public class AppointmentManagementService {
    
    private final AppointmentRepository appointmentRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final PatientRepository patientRepository;

    public final String PATIENT_NOT_FOUND = "Incorrect patient ID";
    public final String TIMESLOT_NOT_FOUND = "Could not find timeslot";
    public final String DOCTOR_BUSY = "The doctor is not free at this time";
    public final String PATIENT_BUSY = "The patient is not free at this time";




    public AppointmentManagementService(AppointmentRepository appointmentRepository, TimeSlotRepository timeSlotRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.timeSlotRepository = timeSlotRepository;
        this.patientRepository = patientRepository;
    }

    public String bookAppointment(int patientId, TimeSlot timeSlot) 
    {
        //Check patient validity
        Optional<Patient> patient = patientRepository.findById(patientId);
        if (patient.isEmpty())
            return PATIENT_NOT_FOUND;

        //Check timeslot validity
        TimeSlotId timeSlotId = new TimeSlotId(timeSlot.getClinic(), timeSlot.getDoctor(), timeSlot.getDate(), timeSlot.getStartTime());
        
        if(timeSlotRepository.findById(timeSlotId).isEmpty())
            return TIMESLOT_NOT_FOUND;

        //Check if doctor has already booked an appointment for this time slot
        Pageable pageable = PageRequest.of(1, 1);
        Page<Appointment> appointments = appointmentRepository.findAllByTimeSlotDoctor(timeSlot.getDoctor(), pageable);
        if(!appointments.isEmpty())
            return DOCTOR_BUSY;
        
        //Check if patient has already booked an appointment for this time slot
        appointments = appointmentRepository.findAllByPatient(Patient.builder().id(patientId).build(), pageable);
        if(!appointments.isEmpty())
            return PATIENT_BUSY;

        Appointment appointment = new Appointment();
        appointment.setPatient(patient.get());
        appointment.setTimeSlot(timeSlot);
        appointmentRepository.save(appointment);
        //Notify patient of appointment booking
        return "";
    }
}
