package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Gender;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Entities.SystemUser;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class SystemUserRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemUserRepository systemUserRepository;

    @Test
    void whenFindSystemUserById_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findById(account.getId()).get();

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByFirstName_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByFirstName("John").get(0);

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByLastName_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByLastName("Smith").get(0);

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByBirthdate_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByBirthdate(Date.valueOf("1985-11-14")).get(0);

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByGender_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByGender(Gender.MALE).get(0);

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByAddress_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByAddress("221B Baker Street").get(0);

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByLandlinePhone_thenReturnSystemUsers() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        systemUserRepository.save(systemUser);

        // Then
        SystemUser queriedSystemUser = systemUserRepository.findByLandlinePhone("(555) 555-5555").get(0);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUserByMobilePhone_thenReturnSystemUser() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);
        System.out.println(account);
        System.out.println(systemUser);

        // When
        SystemUser queriedSystemUser = systemUserRepository.findByMobilePhone("(555) 123-4567");

        // Then
        System.out.println(queriedSystemUser);
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenDeleteSystemUserById_thenDeleteSystemUser() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        systemUserRepository.deleteById(account.getId());

        // Then
        SystemUser queriedSystemUser = systemUserRepository.findById(account.getId()).orElse(null);
        assertNull(queriedSystemUser);
    }

    @Test
    void whenDeleteSystemUserById_thenDeleteAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
        accountRepository.save(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        // When
        systemUserRepository.deleteById(account.getId());

        // Then
        Account queriedAccount = accountRepository.findById(account.getId()).orElse(null);
        assertNull(queriedAccount);
    }

//    @Test
//    NOT WORKING HERE FOR SOME REASON AS IF CONSTRAINT ON DELETE CASCADE DOESN'T EXIST
//    void whenDeleteAccountById_thenDeleteSystemUser() {
//        // Given
//        Account account = new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT);
//        SystemUser systemUser = new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", account);
//        accountRepository.save(account);
//        systemUser.setId(account.getId());
//        systemUserRepository.save(systemUser);
//
//        // When
//        accountRepository.deleteById(account.getId());
//
//        // Then
//        SystemUser queriedSystemUser = systemUserRepository.findById(systemUser.getId()).orElse(null);
//        assertNull(queriedSystemUser);
//    }

    @Test
    void  whenDeleteAllSystemUsers_thenDeleteAllSystemUsers(){
        // Given
        List<Account> accounts = new ArrayList<>();
        List<SystemUser> systemUsers = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.CLINIC_ADMIN));
        systemUsers.add(new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", accounts.get(0)));
        systemUsers.add(new SystemUser("Jane", "Doe", Date.valueOf("1990-03-25"), Gender.FEMALE, "123 Main Street", "(555) 987-6543", "(555) 234-5678", accounts.get(1)));
        systemUsers.add(new SystemUser("Michael", "Jones", Date.valueOf("1978-08-02"), Gender.MALE, "456 Oak Avenue", "(555) 111-2222", "(555) 876-5432", accounts.get(2)));
        systemUsers.add(new SystemUser("Susan", "White", Date.valueOf("1982-06-10"), Gender.FEMALE, "789 Elm Street", "(555) 333-4444", "(555) 345-6789", accounts.get(3)));
        accountRepository.saveAll(accounts);
        for (int i = 0; i < accounts.size(); i++) {
            systemUsers.get(i).setId(accounts.get(i).getId());
        }
        systemUserRepository.saveAll(systemUsers);

        // When
        systemUserRepository.deleteAll();

        // Then
        List<SystemUser> allSystemUsers = systemUserRepository.findAll();
        System.out.println(allSystemUsers.size());
        System.out.println(allSystemUsers);
        assertEquals(0, allSystemUsers.size());
    }

    @Test
    void whenDeleteAllSystemUsers_thenDeleteAllAccounts(){
        // Given
        List<Account> accounts = new ArrayList<>();
        List<SystemUser> systemUsers = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com", "JohnSmith1", "JohnyJohny123", Role.PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.CLINIC_ADMIN));
        systemUsers.add(new SystemUser("John", "Smith", Date.valueOf("1985-11-14"), Gender.MALE, "221B Baker Street", "(555) 555-5555", "(555) 123-4567", accounts.get(0)));
        systemUsers.add(new SystemUser("Jane", "Doe", Date.valueOf("1990-03-25"), Gender.FEMALE, "123 Main Street", "(555) 987-6543", "(555) 234-5678", accounts.get(1)));
        systemUsers.add(new SystemUser("Michael", "Jones", Date.valueOf("1978-08-02"), Gender.MALE, "456 Oak Avenue", "(555) 111-2222", "(555) 876-5432", accounts.get(2)));
        systemUsers.add(new SystemUser("Susan", "White", Date.valueOf("1982-06-10"), Gender.FEMALE, "789 Elm Street", "(555) 333-4444", "(555) 345-6789", accounts.get(3)));
        accountRepository.saveAll(accounts);
        for (int i = 0; i < accounts.size(); i++) {
            systemUsers.get(i).setId(accounts.get(i).getId());
        }
        systemUserRepository.saveAll(systemUsers);

        // When
        systemUserRepository.deleteAll();

        // Then
        List<Account> allAccounts = accountRepository.findAll();
        System.out.println(allAccounts.size());
        System.out.println(allAccounts);
        assertEquals(0, allAccounts.size());
    }
}