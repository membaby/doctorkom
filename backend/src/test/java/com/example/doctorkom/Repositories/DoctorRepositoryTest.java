package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import javax.print.Doc;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class DoctorRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    void whenFindDoctorById_thenReturnDoctor() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        Doctor queriedDoctor = null;
        if (doctorRepository.findById(doctor.getId()).isPresent())
            queriedDoctor = doctorRepository.findById(doctor.getId()).get();

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenFindDoctorsByTitle_thenReturnDoctors() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        Doctor queriedDoctor = doctorRepository.findByTitle(DoctorTitle.PROFESSOR).get(0);

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenFindDoctorsBySpecialty_thenReturnDoctors() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        Doctor queriedDoctor = doctorRepository.findBySpecialty(DoctorSpecialty.ONCOLOGIST).get(0);

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenDeleteDoctorById_thenDeleteDoctor() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(doctorRepository.existsById(doctor.getId()));
    }

    @Test
    void whenDeleteDoctorById_thenDeleteSystemUser() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(systemUserRepository.existsById(systemUser.getId()));
    }

    @Test
    void whenDeleteDoctorById_thenDeleteAccount() {
        // Given
        Account account = Account.builder().
                email("drsmith@hospital.com").
                username("DrSmith1").
                password("Medical123").
                role(Role.DOCTOR).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("Smith").
                lastName("Health").
                birthdate(Date.valueOf("1976-10-30")).
                gender(Gender.MALE).
                address("123 Main Street").
                mobilePhone("(666) 666-6666").
                landlinePhone("(555) 765-4321").
                account(account).
                build();

        Doctor doctor = Doctor.builder().
                title(DoctorTitle.PROFESSOR).
                specialty(DoctorSpecialty.ONCOLOGIST).
                systemUser(systemUser).
                build();

        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }
}