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
class PatientRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Test
    void whenFindPatientById_thenAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        Patient patient = new Patient("BOBA", systemUser);

        accountRepository.save(account);
        systemUser.setId(account.getId());
        System.out.println(systemUser);
        systemUserRepository.save(systemUser);
        patient.setId(systemUser.getId());
        System.out.println(patient);
        patientRepository.save(patient);

        // When
        Patient queriedPatient = patientRepository.findById(patient.getId()).get();

        // Then
        System.out.println(queriedPatient);
        assertEquals(queriedPatient, patient);
    }
}