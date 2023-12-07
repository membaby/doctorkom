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
class
PatientRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void whenFindPatientById_thenReturnPatient() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        Patient queriedPatient = null;
        if (patientRepository.findById(patient.getId()).isPresent())
            queriedPatient = patientRepository.findById(patient.getId()).get();

        // Then
        assertEquals(patient, queriedPatient);
    }

    @Test
    void whenFindPatientsByOccupation_thenReturnPatients() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        Patient queriedPatient = null;
        if (patientRepository.findByOccupation("Engineer").isPresent())
            queriedPatient = patientRepository.findByOccupation("Engineer").get().get(0);

        // Then
        assertEquals(queriedPatient, patient);
    }

    @Test
    void whenFindPatientsByMaritalStatus_thenReturnPatients() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        Patient queriedPatient = null;
        if (patientRepository.findByMaritalStatus("Single").isPresent())
            queriedPatient = patientRepository.findByMaritalStatus("Single").get().get(0);

        // Then
        assertEquals(patient, queriedPatient);
    }

    @Test
    void whenFindPatientsByInsurance_thenReturnPatients() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        Patient queriedPatient = null;
        if (patientRepository.findByInsurance("BOBA").isPresent())
            queriedPatient = patientRepository.findByInsurance("BOBA").get().get(0);

        // Then
        assertEquals(patient, queriedPatient);
    }

    @Test
    void whenDeletePatientById_thenDeletePatient() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        patientRepository.deleteById(patient.getId());

        // Then
        assertFalse(patientRepository.existsById(patient.getId()));
    }

    @Test
    void whenDeletePatientById_thenDeleteSystemUser() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        patientRepository.deleteById(patient.getId());

        // Then
        assertFalse(systemUserRepository.existsById(systemUser.getId()));
    }

    @Test
    void whenDeletePatientById_thenDeleteAccount() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        SystemUser systemUser = SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(account).
                build();

        Patient patient = Patient.builder().
                occupation("Engineer").
                maritalStatus("Single").
                insurance("BOBA").
                systemUser(systemUser).
                build();

        patientRepository.save(patient);

        // When
        patientRepository.deleteById(patient.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }
}