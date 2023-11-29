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
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
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
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
        doctorRepository.save(doctor);

        // When
        Doctor queriedDoctor = null;
        if (doctorRepository.findByTitle(DoctorTitle.PROFESSOR).isPresent())
            queriedDoctor = doctorRepository.findByTitle(DoctorTitle.PROFESSOR).get().get(0);

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenFindDoctorsBySpecialty_thenReturnDoctors() {
        // Given
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
        doctorRepository.save(doctor);

        // When
        Doctor queriedDoctor = null;
        if (doctorRepository.findBySpecialty(DoctorSpecialty.ONCOLOGIST).isPresent())
            queriedDoctor = doctorRepository.findBySpecialty(DoctorSpecialty.ONCOLOGIST).get().get(0);

        // Then
        assertEquals(doctor, queriedDoctor);
    }

    @Test
    void whenDeleteDoctorById_thenDeleteDoctor() {
        // Given
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(doctorRepository.existsById(doctor.getId()));
    }

    @Test
    void whenDeleteDoctorById_thenDeleteSystemUser() {
        // Given
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(systemUserRepository.existsById(systemUser.getId()));
    }

    @Test
    void whenDeleteDoctorById_thenDeleteAccount() {
        // Given
        Account account = new Account("drsmith@hospital.com", "DrSmith1", "Medical123", Role.DOCTOR);
        SystemUser systemUser = new SystemUser("Smith", "Health", Date.valueOf("1976-10-30"), Gender.MALE, "123 Main Street", "(666) 666-6666", "(555) 765-4321", account);
        Doctor doctor = new Doctor(DoctorTitle.PROFESSOR, DoctorSpecialty.ONCOLOGIST, systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        doctor.setId(systemUser.getId());
        doctorRepository.save(doctor);

        // When
        doctorRepository.deleteById(doctor.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }
}