package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.AppointmentRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Repositories.TimeSlotRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DataJpaTest
public class AppointmentRepositoryTest {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Test
    public void testSaveAppointment() {
        Patient patient = createPatient();
        TimeSlot timeSlot = createTimeslot();

        patientRepository.save(patient);
        timeSlotRepository.save(timeSlot);

        Appointment appointment = new Appointment();
        appointment.setPatient(patient);
        appointment.setTimeSlot(timeSlot);

        appointmentRepository.save(appointment);

        Appointment savedAppointment = appointmentRepository.findById(new AppointmentId(timeSlot, patient)).orElse(null);

        assertNotNull(savedAppointment);
        assertEquals(patient.getId(), savedAppointment.getPatient().getId());
        assertEquals(timeSlot.getStartTime(), savedAppointment.getTimeSlot().getStartTime());
    }

    Account createPatientAccount() {
        return Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();
    }

    SystemUser createPatientSystemUser(){
        return SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(createPatientAccount()).
                build();
    }

    Patient createPatient(){
        return Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(createPatientSystemUser()).
                build();
    }

    TimeSlot createTimeslot() {
        return TimeSlot.builder().
                startTime(Time.valueOf("10:00:00")).
                endTime(Time.valueOf("10:30:00")).
                build();
    }
}
