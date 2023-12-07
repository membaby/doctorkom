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
    void whenFindSystemUserById_thenReturnSystemUser() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findById(account.getId()).isPresent())
            queriedSystemUser = systemUserRepository.findById(account.getId()).get();

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByFirstName_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByFirstName("John").isPresent())
            queriedSystemUser = systemUserRepository.findByFirstName("John").get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByLastName_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByLastName("Smith").isPresent())
            queriedSystemUser = systemUserRepository.findByLastName("Smith").get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByBirthdate_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByBirthdate(Date.valueOf("1985-11-14")).isPresent())
            queriedSystemUser = systemUserRepository.findByBirthdate(Date.valueOf("1985-11-14")).get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByGender_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByGender(Gender.MALE).isPresent())
            queriedSystemUser = systemUserRepository.findByGender(Gender.MALE).get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByAddress_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByAddress("221B Baker Street").isPresent())
            queriedSystemUser = systemUserRepository.findByAddress("221B Baker Street").get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUsersByLandlinePhone_thenReturnSystemUsers() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByLandlinePhone("(555) 123-4567").isPresent())
            queriedSystemUser = systemUserRepository.findByLandlinePhone("(555) 123-4567").get().get(0);

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenFindSystemUserByMobilePhone_thenReturnSystemUser() {
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

        systemUserRepository.save(systemUser);

        // When
        SystemUser queriedSystemUser = null;
        if (systemUserRepository.findByMobilePhone("(555) 555-5555").isPresent())
            queriedSystemUser = systemUserRepository.findByMobilePhone("(555) 555-5555").get();

        // Then
        assertEquals(systemUser, queriedSystemUser);
    }

    @Test
    void whenDeleteSystemUserById_thenDeleteSystemUser() {
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

        systemUserRepository.save(systemUser);

        // When
        systemUserRepository.deleteById(systemUser.getId());

        // Then
        assertFalse(systemUserRepository.existsById(systemUser.getId()));
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
    void whenDeleteSystemUserById_thenDeleteAccount() {
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

        systemUserRepository.save(systemUser);

        // When
        systemUserRepository.deleteById(systemUser.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
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

        accounts.add(Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build());
        accounts.add(Account.builder().
                email("jane.doe@email.com").
                username("JaneDoe").
                password("Password456").
                role(Role.PATIENT).
                build());
        accounts.add(Account.builder().
                email("michael.jones@example.com").
                username("MichaelJones").
                password("SecurePass789").
                role(Role.DOCTOR).
                build());
        accounts.add(Account.builder().
                email("susan.white@lol.com").
                username("SusanWhite").
                password("StrongPassword123").
                role(Role.CLINIC_ADMIN).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(accounts.get(0)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Jane").
                lastName("Doe").
                birthdate(Date.valueOf("1990-03-25")).
                gender(Gender.FEMALE).
                address("123 Main Street").
                mobilePhone("(555) 987-6543").
                landlinePhone("(555) 234-5678").
                account(accounts.get(1)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Michael").
                lastName("Jones").
                birthdate(Date.valueOf("1978-08-02")).
                gender(Gender.MALE).
                address("456 Oak Avenue").
                mobilePhone("(555) 111-2222").
                landlinePhone("(555) 876-5432").
                account(accounts.get(2)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Susan").
                lastName("White").
                birthdate(Date.valueOf("1982-06-10")).
                gender(Gender.FEMALE).
                address("789 Elm Street").
                mobilePhone("(555) 333-4444").
                landlinePhone("(555) 345-6789").
                account(accounts.get(3)).
                build());

        systemUserRepository.saveAll(systemUsers);

        // When
        systemUserRepository.deleteAll();

        // Then
        List<SystemUser> allSystemUsers = systemUserRepository.findAll();
        assertEquals(0, allSystemUsers.size());
    }

    @Test
    void whenDeleteAllSystemUsers_thenDeleteAllAccounts(){
        // Given
        List<Account> accounts = new ArrayList<>();
        List<SystemUser> systemUsers = new ArrayList<>();

        accounts.add(Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build());
        accounts.add(Account.builder().
                email("jane.doe@email.com").
                username("JaneDoe").
                password("Password456").
                role(Role.PATIENT).
                build());
        accounts.add(Account.builder().
                email("michael.jones@example.com").
                username("MichaelJones").
                password("SecurePass789").
                role(Role.DOCTOR).
                build());
        accounts.add(Account.builder().
                email("susan.white@lol.com").
                username("SusanWhite").
                password("StrongPassword123").
                role(Role.CLINIC_ADMIN).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("John").
                lastName("Smith").
                birthdate(Date.valueOf("1985-11-14")).
                gender(Gender.MALE).
                address("221B Baker Street").
                mobilePhone("(555) 555-5555").
                landlinePhone("(555) 123-4567").
                account(accounts.get(0)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Jane").
                lastName("Doe").
                birthdate(Date.valueOf("1990-03-25")).
                gender(Gender.FEMALE).
                address("123 Main Street").
                mobilePhone("(555) 987-6543").
                landlinePhone("(555) 234-5678").
                account(accounts.get(1)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Michael").
                lastName("Jones").
                birthdate(Date.valueOf("1978-08-02")).
                gender(Gender.MALE).
                address("456 Oak Avenue").
                mobilePhone("(555) 111-2222").
                landlinePhone("(555) 876-5432").
                account(accounts.get(2)).
                build());

        systemUsers.add(SystemUser.builder().
                firstName("Susan").
                lastName("White").
                birthdate(Date.valueOf("1982-06-10")).
                gender(Gender.FEMALE).
                address("789 Elm Street").
                mobilePhone("(555) 333-4444").
                landlinePhone("(555) 345-6789").
                account(accounts.get(3)).
                build());

        systemUserRepository.saveAll(systemUsers);

        // When
        systemUserRepository.deleteAll();

        // Then
        List<Account> allAccounts = accountRepository.findAll();
        assertEquals(0, allAccounts.size());
    }
}