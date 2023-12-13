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
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

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
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

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
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

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
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        accountRepository.save(account);

        // When
        Account queriedAccount = accountRepository.findByRole(Role.PATIENT).get(0);

        // Then
        assertEquals(account, queriedAccount);
    }

    @Test
    public void whenFindAllAccounts_thenReturnAllAccounts() {
        // Given
        List<Account> accounts = new ArrayList<>();
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

        accountRepository.saveAll(accounts);

        // When
        List<Account> allAccounts = accountRepository.findAll();

        // Then
        assertEquals(accounts.size(), allAccounts.size());
    }

    @Test
    public void whenDeleteAccountById_thenDeleteAccount() {
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        accountRepository.save(account);

        // When
        accountRepository.deleteById(account.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void WhenDeleteAccountByEmail_thenDeleteAccount(){
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

        accountRepository.save(account);

        // When
        accountRepository.deleteByEmail("johnsmith123@lol.com");

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }

    @Test
    public void WhenDeleteAccountByUsername_thenDeleteAccount(){
        // Given
        Account account = Account.builder().
                email("johnsmith123@lol.com").
                username("JohnSmith1").
                password("JohnyJohny123").
                role(Role.PATIENT).
                build();

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

        accountRepository.saveAll(accounts);

        // When
        accountRepository.deleteAll();

        // Then
        List<Account> allAccounts = accountRepository.findAll();
        assertEquals(0, allAccounts.size());
    }
}
