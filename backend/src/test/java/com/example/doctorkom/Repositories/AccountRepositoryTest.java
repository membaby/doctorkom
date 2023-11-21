package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

//Unit tests use H2 in-memory db to perform testing (schema and data found in main/resources)
@ActiveProfiles("test")
@DataJpaTest
class AccountRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindByID_thenReturnAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = accountRepository.findById(account.getId()).get();

        // Then
        System.out.println(queriedAccount);
        assertEquals(queriedAccount, account);
    }

    @Test
    public void WhenFindByEmail_thenReturnAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = accountRepository.findByEmail("johnsmith123@lol.com");

        // Then
        System.out.println(queriedAccount);
        assertEquals(account, queriedAccount);
    }

    @Test
    public void WhenFindByUsername_thenReturnAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = accountRepository.findByUsername("JohnSmith1");

        // Then
        System.out.println(queriedAccount);
        assertEquals(account, queriedAccount);
    }

    @Test
    public void WhenFindByRole_thenReturnAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = accountRepository.findByRole(Role.ROLE_PATIENT);

        // Then
        System.out.println(queriedAccount);
        assertEquals(account, queriedAccount);
    }

    @Test
    public void whenFindAll_thenReturnAllAccounts() {
        // Given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.ROLE_PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.ROLE_DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.ROLE_CLINIC_ADMIN));
        accountRepository.saveAll(accounts);

        // When
        List<Account> allAccounts = accountRepository.findAll();

        // Then
        System.out.println(allAccounts.size());
        System.out.println(allAccounts);
        assertEquals(accounts.size(), allAccounts.size());
    }

    @Test
    public void whenDeleteById_thenDeleteAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteById(account.getId());

        // Then
        Account queriedAccount = accountRepository.findById(account.getId()).orElse(null);
        assertNull(queriedAccount);
    }

    @Test
    public void WhenDeleteByEmail_thenDeleteAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteByEmail("johnsmith123@lol.com");

        // Then
        Account queriedAccount = accountRepository.findByEmail(account.getEmail());
        assertNull(queriedAccount);
    }

    @Test
    public void WhenDeleteByUsername_thenDeleteAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteByUsername("JohnSmith1");

        // Then
        Account queriedAccount = accountRepository.findByUsername(account.getUsername());
        assertNull(queriedAccount);
    }

    @Test
    public void whenDeleteAll_thenDeleteAllAccounts() {
        // Given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.ROLE_PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.ROLE_PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.ROLE_DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.ROLE_CLINIC_ADMIN));
        accountRepository.saveAll(accounts);

        // When
        accountRepository.deleteAll();

        // Then
        List<Account> allAccounts = accountRepository.findAll();
        System.out.println(allAccounts.size());
        System.out.println(allAccounts);
        assertEquals(0, allAccounts.size());
    }
}
