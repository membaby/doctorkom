package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

//Unit tests use H2 in-memory db to perform testing (schema and data found in main/resources)
@ActiveProfiles("test")
@DataJpaTest
class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenFindAccountByID_thenReturnAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = null;
        if (accountRepository.findById(account.getId()).isPresent())
            queriedAccount = accountRepository.findById(account.getId()).get();

        // Then
        assertEquals(queriedAccount, account);
    }

    @Test
    public void WhenFindAccountByEmail_thenReturnAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = null;
        if (accountRepository.findByEmail("johnsmith123@lol.com").isPresent())
            queriedAccount = accountRepository.findByEmail("johnsmith123@lol.com").get();

        // Then
        assertEquals(account, queriedAccount);
    }

    @Test
    public void WhenFindAccountByUsername_thenReturnAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = null;
        if (accountRepository.findByUsername("JohnSmith1").isPresent())
            queriedAccount = accountRepository.findByUsername("JohnSmith1").get();

        // Then
        assertEquals(account, queriedAccount);
    }

    @Test
    public void WhenFindAccountsByRole_thenReturnAccounts(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        Account queriedAccount = null;
        if (accountRepository.findByRole(Role.PATIENT).isPresent())
            queriedAccount = accountRepository.findByRole(Role.PATIENT).get().get(0);

        // Then
        assertEquals(account, queriedAccount);
    }

    @Test
    public void whenFindAllAccounts_thenReturnAllAccounts() {
        // Given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.CLINIC_ADMIN));
        accountRepository.saveAll(accounts);

        // When
        List<Account> allAccounts = accountRepository.findAll();

        // Then
        assertEquals(accounts.size(), allAccounts.size());
    }

    @Test
    public void whenDeleteAccountById_thenDeleteAccount() {
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteById(account.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void WhenDeleteAccountByEmail_thenDeleteAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteByEmail("johnsmith123@lol.com");

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void WhenDeleteAccountByUsername_thenDeleteAccount(){
        // Given
        Account account = new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT);
        accountRepository.save(account);

        // When
        accountRepository.deleteByUsername("JohnSmith1");

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void whenDeleteAllAccounts_thenDeleteAllAccounts() {
        // Given
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account("johnsmith123@lol.com","JohnSmith1", "JohnyJohny123", Role.PATIENT));
        accounts.add(new Account("jane.doe@email.com", "JaneDoe", "Password456", Role.PATIENT));
        accounts.add(new Account("michael.jones@example.com", "MichaelJones", "SecurePass789", Role.DOCTOR));
        accounts.add(new Account("susan.white@lol.com", "SusanWhite", "StrongPassword123", Role.CLINIC_ADMIN));
        accountRepository.saveAll(accounts);

        // When
        accountRepository.deleteAll();

        // Then
        List<Account> allAccounts = accountRepository.findAll();
        assertEquals(0, allAccounts.size());
    }
}
