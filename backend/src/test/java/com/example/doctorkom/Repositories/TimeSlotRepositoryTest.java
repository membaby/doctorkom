
/*
package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ActiveProfiles("test")
@DataJpaTest
class TimeSlotRepositoryTest {
    @Autowired
    private TimeSlotRepository timeSlotRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void whenFindTimeSlotsByClinicId_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByClinicId(clinic.getId()).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }

    @Test
    void whenFindTimeSlotsByDoctorId_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);

        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByDoctorId(doctor.getId()).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }

   */
/* @Test
    void whenFindTimeSlotsByDate_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByDate(Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }*//*


   */
/* @Test
    void whenFindTimeSlotsByDoctorIdAndClinicId_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByDoctorIdAndClinicId(doctor.getId(), clinic.getId()).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }*//*


    @Test
    void whenFindTimeSlotsByDoctorIdAndDate_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByDoctorIdAndDate(doctor.getId(), Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }

    @Test
    void whenFindTimeSlotsByClinicIdAndDate_thenReturnTimeSlots() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = timeSlotRepository.findByClinicIdAndDate(clinic.getId(), Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }

    */
/*@Test
    void whenFindTimeSlotByDoctorIdAndClinicIdAndDate_thenReturnTimeSlot() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        TimeSlot queriedTimeSlot = null;
        if (timeSlotRepository.findByDoctorIdAndClinicIdAndDate(doctor.getId(), clinic.getId(), Date.valueOf("2023-04-01")).isPresent())
            queriedTimeSlot = timeSlotRepository.findByDoctorIdAndClinicIdAndDate(doctor.getId(), clinic.getId(), Date.valueOf("2023-04-01")).get();

        // Then
        assertEquals(timeSlot, queriedTimeSlot);
    }*//*


    @Test
    void whenDeleteTimeSlot_thenDoNotDeleteClinic() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        timeSlotRepository.deleteById(new TimeSlotId(clinic, doctor, Date.valueOf("2023-04-01"), Time.valueOf("09:00:00")));
        Clinic queriedClinic = null;
        if (clinicRepository.findById(clinic.getId()).isPresent())
            queriedClinic = clinicRepository.findById(clinic.getId()).get();

        // Then
        assertEquals(clinic, queriedClinic);
    }

    @Test
    void whenDeleteTimeSlot_thenDoNotDeleteDoctor() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        timeSlotRepository.deleteById(new TimeSlotId(clinic, doctor, Date.valueOf("2023-04-01"), Time.valueOf("09:00:00")));
        Doctor queriedDoctor = null;
        if (doctorRepository.findById(doctor.getId()).isPresent())
            queriedDoctor = doctorRepository.findById(doctor.getId()).get();

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenDeleteByClinicId_thenDeleteTimeSlot() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        timeSlotRepository.deleteByClinicId(clinic.getId());

        // Then
        assertTrue(timeSlotRepository.findByClinicId(clinic.getId()).isEmpty());
    }

    @Test
    void whenDeleteByDoctorId_thenDeleteTimeSlot() {
        // Given
        Clinic clinic = createClinic();
        clinicRepository.save(clinic);

        Doctor doctor = createDoctor();
        doctorRepository.save(doctor);

        TimeSlot timeSlot = createTimeSlot(clinic, doctor);
        timeSlotRepository.save(timeSlot);

        clinic.addTimeSlot(timeSlot);
        doctor.addTimeSlot(timeSlot);

        clinicRepository.save(clinic);
        doctorRepository.save(doctor);

        timeSlotRepository.save(timeSlot);

        // When
        timeSlotRepository.deleteByDoctorId(doctor.getId());

        // Then
        assertTrue(timeSlotRepository.findByDoctorId(doctor.getId()).isEmpty());
    }

    Account createClinicAdminAccount() {
        return Account.builder().
                email("nursejane@clinic.com").
                username("NurseJane1").
                password("Healthcare456").
                role(Role.CLINIC_ADMIN).
                build();
    }

    ClinicAdmin createClinicAdmin() {
        return ClinicAdmin.builder().
                account(createClinicAdminAccount()).
                build();
    }

    Clinic createClinic() {
        return Clinic.builder().
                name("Clinic1").
                address("123 Main St").
                email("Clinic1@org.com").
                mobilePhone("1234567890").
                landlinePhone("(555) 555-5555").
                admin(createClinicAdmin()).
                build();
    }

    Account createDoctorAccount() {
        return Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();
    }

    SystemUser createDoctorSystemUser(){
        return SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(createDoctorAccount()).
                build();
    }

    Doctor createDoctor(){
        return Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(createDoctorSystemUser()).
                build();
    }

    TimeSlot createTimeSlot(Clinic clinic, Doctor doctor){
        return TimeSlot.builder().
                clinic(clinic).
                doctor(doctor).
                date(Date.valueOf("2023-04-01")).
                startTime(Time.valueOf("09:00:00")).
                endTime(Time.valueOf("10:00:00")).
                reserved(false).
                build();
    }
}*/
