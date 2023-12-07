package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByPatientId(patient.getId()).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByPatientId(patient.getId()).get().get(0);

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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByDoctorId(doctor.getId()).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByDoctorId(doctor.getId()).get().get(0);

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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByDate(Date.valueOf("2023-04-01")).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByDate(Date.valueOf("2023-04-01")).get().get(0);

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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByDoctorIdAndPatientId(doctor.getId(), patient.getId()).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByDoctorIdAndPatientId(doctor.getId(), patient.getId()).get().get(0);

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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByDoctorIdAndDate(doctor.getId(), Date.valueOf("2023-04-01")).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByDoctorIdAndDate(doctor.getId(), Date.valueOf("2023-04-01")).get().get(0);

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

        // When
        MedicalNote queriedMedicalNote = null;
        if (medicalNoteRepository.findByPatientIdAndDate(patient.getId(), Date.valueOf("2023-04-01")).isPresent())
            queriedMedicalNote = medicalNoteRepository.findByPatientIdAndDate(patient.getId(), Date.valueOf("2023-04-01")).get().get(0);

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

        // When
        medicalNoteRepository.delete(medicalNote);
        Patient queriedPatient = patientRepository.findById(patient.getId()).get();

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

        // When
        medicalNoteRepository.delete(medicalNote);
        Doctor queriedDoctor = doctorRepository.findById(doctor.getId()).get();

        // Then
        assertEquals(doctor, queriedDoctor);
    }
}