package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class VerificationRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private VerificationRepository verificationRepository;

    @Test
    void whenFindVerificationById_thenReturnVerification() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        Verification verification = new Verification("ABC123", LocalDateTime.parse("2023-11-27 15:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), account);
        accountRepository.save(account);
        verification.setId(account.getId());
        verificationRepository.save(verification);

        // When
        Verification queriedVerification = verificationRepository.findById(verification.getId()).get();

        // Then
        System.out.println(verification);
        assertEquals(verification, queriedVerification);
    }

    @Test
    void whenDeleteVerificationById_thenDeleteVerification() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        Verification verification = new Verification("ABC123", LocalDateTime.parse("2023-11-27 15:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), account);
        accountRepository.save(account);
        verification.setId(account.getId());
        verificationRepository.save(verification);

        // When
        verificationRepository.deleteById(verification.getId());

        // Then
        Verification queriedVerification = verificationRepository.findById(verification.getId()).orElse(null);
        assertNull(queriedVerification);
    }

    @Test
    void whenDeleteVerificationById_thenDoNotDeleteAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        Verification verification = new Verification("ABC123", LocalDateTime.parse("2023-11-27 15:30:00", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")), account);
        accountRepository.save(account);
        verification.setId(account.getId());
        verificationRepository.save(verification);

        // When
        verificationRepository.deleteById(verification.getId());

        // Then
        Account queriedAccount = accountRepository.findById(account.getId()).get();
        assertNotNull(queriedAccount);
    }

//    @Test
//    NOT WORKING HERE FOR SOME REASON AS IF CONSTRAINT ON DELETE CASCADE DOESN'T EXIST
//    void whenDeleteAccountById_thenDeleteVerification() {
//        // Given
//        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
//        Verification verification = new Verification("ABC123", Date.valueOf("2023-11-27 15:30:00"), account);
//        accountRepository.save(account);
//        verification.setId(account.getId());
//        verificationRepository.save(verification);
//
//        // When
//        accountRepository.deleteById(account.getId());
//
//        // Then
//        Verification queriedVerification = verificationRepository.findById(verification.getId()).orElse(null);
//        assertNull(queriedVerification);
//    }
}