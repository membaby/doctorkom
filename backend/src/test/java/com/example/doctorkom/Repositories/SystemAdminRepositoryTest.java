package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class SystemAdminRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private SystemAdminRepository systemAdminRepository;

    @Test
    void whenFindSystemAdminById_thenReturnSystemAdmin() {
        // Given
        Account account = new Account("admin@system.com", "AdminUser1", "AdminPass123", Role.SYSTEM_ADMIN);
        SystemAdmin systemAdmin = new SystemAdmin(account);

        accountRepository.save(account);
        systemAdmin.setId(account.getId());
        systemAdminRepository.save(systemAdmin);

        // When
        SystemAdmin queriedSystemAdmin = null;
        if (systemAdminRepository.findById(account.getId()).isPresent())
            queriedSystemAdmin = systemAdminRepository.findById(account.getId()).get();

        // Then
        assertEquals(systemAdmin, queriedSystemAdmin);
    }

    @Test
    void whenDeleteSystemAdminById_thenDeleteSystemAdmin() {
        // Given
        Account account = new Account("admin@system.com", "AdminUser1", "AdminPass123", Role.SYSTEM_ADMIN);
        SystemAdmin systemAdmin = new SystemAdmin(account);

        accountRepository.save(account);
        systemAdmin.setId(account.getId());
        systemAdminRepository.save(systemAdmin);

        // When
        systemAdminRepository.deleteById(systemAdmin.getId());

        // Then
        assertFalse(systemAdminRepository.existsById(systemAdmin.getId()));
    }

    @Test
    void whenDeleteSystemAdminById_thenDeleteAccount() {
        // Given
        Account account = new Account("admin@system.com", "AdminUser1", "AdminPass123", Role.SYSTEM_ADMIN);
        SystemAdmin systemAdmin = new SystemAdmin(account);

        accountRepository.save(account);
        systemAdmin.setId(account.getId());
        systemAdminRepository.save(systemAdmin);

        // When
        systemAdminRepository.deleteById(systemAdmin.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }
}