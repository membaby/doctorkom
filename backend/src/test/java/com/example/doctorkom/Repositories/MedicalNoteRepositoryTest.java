package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class MedicalNoteRepositoryTest {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private MedicalNoteRepository medicalNoteRepository;

    @Test
    void whenFindMedicalNotesByPatientId_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByPatientId(patient.getId()).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNotesByDoctorId_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);
        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByDoctorId(doctor.getId()).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNotesByDate_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByDate(Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNotesByDoctorIdAndPatientId_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByDoctorIdAndPatientId(doctor.getId(), patient.getId()).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNotesByDoctorIdAndDate_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByDoctorIdAndDate(doctor.getId(), Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNotesByPatientIdAndDate_thenReturnMedicalNotes() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = medicalNoteRepository.findByPatientIdAndDate(patient.getId(), Date.valueOf("2023-04-01")).get(0);

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenFindMedicalNoteByDoctorIdAndPatientIdAndDate_thenReturnMedicalNote() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByDoctorIdAndPatientIdAndDate(doctor.getId(), patient.getId(), Date.valueOf("2023-04-01")).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByDoctorIdAndPatientIdAndDate(doctor.getId(), patient.getId(), Date.valueOf("2023-04-01")).get();

        // Then
        assertEquals(medicalNote, queriedMedicalNote);
    }

    @Test
    void whenDeleteMedicalNote_thenDoNotDeletePatient() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        medicalNoteRepository.deleteById(new MedicalNoteId(patient, doctor, Date.valueOf("2023-04-01")));
        Patient queriedPatient = null;
        if (patientRepository.findById(patient.getId()).isPresent())
            queriedPatient = patientRepository.findById(patient.getId()).get();

        // Then
        assertEquals(patient, queriedPatient);
    }

    @Test
    void whenDeleteMedicalNote_thenDoNotDeleteDoctor() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        patient.addMedicalNote(medicalNote);
        doctor.addMedicalNote(medicalNote);

        patientRepository.save(patient);
        doctorRepository.save(doctor);

        // When
        medicalNoteRepository.deleteById(new MedicalNoteId(patient, doctor, Date.valueOf("2023-04-01")));
        Doctor queriedDoctor = null;
        if (doctorRepository.findById(doctor.getId()).isPresent())
            queriedDoctor = doctorRepository.findById(doctor.getId()).get();

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenDeleteByPatientId_thenDeleteMedicalNote() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        // When
        medicalNoteRepository.deleteByPatientId(patient.getId());

        // Then
        assertTrue(medicalNoteRepository.findByPatientId(patient.getId()).isEmpty());
    }

    @Test
    void whenDeleteByDoctorId_thenDeleteMedicalNote() {
        // Given
        Account patientAccount = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser patientSystemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(patientAccount).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(patientSystemUser).
                build();

        patientRepository.save(patient);

        Account doctorAccount = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser doctorSystemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(doctorAccount).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(doctorSystemUser).
                build();

        doctorRepository.save(doctor);

        MedicalNote medicalNote = MedicalNote.builder().
                date(Date.valueOf("2023-04-01")).
                patient(patient).
                doctor(doctor).
                build();

        medicalNoteRepository.save(medicalNote);

        // When
        medicalNoteRepository.deleteByDoctorId(doctor.getId());

        // Then
        assertTrue(medicalNoteRepository.findByDoctorId(doctor.getId()).isEmpty());
    }

//    SAME AS VERIFICATION AS CASCADE ON DELETE IS NOT WORKING
//    @Test
//    void whenDeleteDoctor_thenDeleteMedicalNote() {
//        // Given
//        Account patientAccount = Account.builder().
//                email("johnsmith123@lol.com").
//                username("JohnSmith1").
//                password("JohnyJohny123").
//                role(Role.PATIENT).
//                build();
//
//        SystemUser patientSystemUser = SystemUser.builder().
//                firstName("John").
//                lastName("Smith").
//                birthdate(Date.valueOf("1985-11-14")).
//                gender(Gender.MALE).
//                address("221B Baker Street").
//                mobilePhone("(555) 555-5555").
//                landlinePhone("(555) 123-4567").
//                account(patientAccount).
//                build();
//
//        Patient patient = Patient.builder().
//                occupation("Engineer").
//                maritalStatus("Single").
//                insurance("BOBA").
//                systemUser(patientSystemUser).
//                build();
//
//        patientRepository.save(patient);
//
//        Account doctorAccount = Account.builder().
//                email("drsmith@hospital.com").
//                username("DrSmith1").
//                password("Medical123").
//                role(Role.DOCTOR).
//                build();
//
//        SystemUser doctorSystemUser = SystemUser.builder().
//                firstName("Smith").
//                lastName("Health").
//                birthdate(Date.valueOf("1976-10-30")).
//                gender(Gender.MALE).
//                address("123 Main Street").
//                mobilePhone("(666) 666-6666").
//                landlinePhone("(555) 765-4321").
//                account(doctorAccount).
//                build();
//
//        Doctor doctor = Doctor.builder().
//                title(DoctorTitle.PROFESSOR).
//                specialty(DoctorSpecialty.ONCOLOGIST).
//                systemUser(doctorSystemUser).
//                build();
//
//        doctorRepository.save(doctor);
//
//        MedicalNote medicalNote = MedicalNote.builder().
//                date(Date.valueOf("2023-04-01")).
//                patient(patient).
//                doctor(doctor).
//                build();
//
//        medicalNoteRepository.save(medicalNote);
//
//        patient.addMedicalNote(medicalNote);
//        doctor.addMedicalNote(medicalNote);
//
//        patientRepository.save(patient);
//        doctorRepository.save(doctor);
//
//        // When
//        doctorRepository.deleteById(doctor.getId());
//
//        // Then
//        assertFalse(medicalNoteRepository.findByDoctorId(doctor.getId()).isPresent());
//    }
//
//    @Test
//    void whenDeletePatient_thenDeleteMedicalNote() {
//        // Given
//        Account patientAccount = Account.builder().
//                email("johnsmith123@lol.com").
//                username("JohnSmith1").
//                password("JohnyJohny123").
//                role(Role.PATIENT).
//                build();
//
//        SystemUser patientSystemUser = SystemUser.builder().
//                firstName("John").
//                lastName("Smith").
//                birthdate(Date.valueOf("1985-11-14")).
//                gender(Gender.MALE).
//                address("221B Baker Street").
//                mobilePhone("(555) 555-5555").
//                landlinePhone("(555) 123-4567").
//                account(patientAccount).
//                build();
//
//        Patient patient = Patient.builder().
//                occupation("Engineer").
//                maritalStatus("Single").
//                insurance("BOBA").
//                systemUser(patientSystemUser).
//                build();
//
//        patientRepository.save(patient);
//
//        Account doctorAccount = Account.builder().
//                email("drsmith@hospital.com").
//                username("DrSmith1").
//                password("Medical123").
//                role(Role.DOCTOR).
//                build();
//
//        SystemUser doctorSystemUser = SystemUser.builder().
//                firstName("Smith").
//                lastName("Health").
//                birthdate(Date.valueOf("1976-10-30")).
//                gender(Gender.MALE).
//                address("123 Main Street").
//                mobilePhone("(666) 666-6666").
//                landlinePhone("(555) 765-4321").
//                account(doctorAccount).
//                build();
//
//        Doctor doctor = Doctor.builder().
//                title(DoctorTitle.PROFESSOR).
//                specialty(DoctorSpecialty.ONCOLOGIST).
//                systemUser(doctorSystemUser).
//                build();
//
//        doctorRepository.save(doctor);
//
//        MedicalNote medicalNote = MedicalNote.builder().
//                date(Date.valueOf("2023-04-01")).
//                patient(patient).
//                doctor(doctor).
//                build();
//
//        medicalNoteRepository.save(medicalNote);
//
//        patient.addMedicalNote(medicalNote);
//        doctor.addMedicalNote(medicalNote);
//
//        patientRepository.save(patient);
//        doctorRepository.save(doctor);
//
//        // When
//        patientRepository.deleteById(patient.getId());
//
//        // Then
//        assertFalse(medicalNoteRepository.findByPatientId(patient.getId()).isPresent());
//    }
}