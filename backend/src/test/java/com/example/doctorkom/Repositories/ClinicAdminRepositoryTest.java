package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@DataJpaTest
class ClinicAdminRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClinicAdminRepository clinicAdminRepository;
    @Test
    void whenFindSystemAdminById_thenReturnSystemAdmin() {
        // Given
        Account account = new Account("nursejane@clinic.com", "NurseJane1", "Healthcare456", Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        clinicAdmin.setAccount(account);

        accountRepository.save(account);
        clinicAdmin.setId(account.getId());
        clinicAdminRepository.save(clinicAdmin);

        // When
        ClinicAdmin queriedClinicAdmin = null;
        if (clinicAdminRepository.findById(account.getId()).isPresent())
            queriedClinicAdmin = clinicAdminRepository.findById(account.getId()).get();

        // Then
        assertEquals(clinicAdmin, queriedClinicAdmin);
    }

    @Test
    void whenDeleteClinicAdminById_thenDeleteClinicAdmin() {
        // Given
        Account account = new Account("nursejane@clinic.com", "NurseJane1", "Healthcare456", Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        clinicAdmin.setAccount(account);

        accountRepository.save(account);
        clinicAdmin.setId(account.getId());
        clinicAdminRepository.save(clinicAdmin);

        // When
        clinicAdminRepository.deleteById(clinicAdmin.getId());

        // Then
        assertFalse(clinicAdminRepository.existsById(account.getId()));
    }

    @Test
    void whenDeleteClinicAdminById_thenDeleteAccount() {
        // Given
        Account account = new Account("nursejane@clinic.com", "NurseJane1", "Healthcare456", Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        clinicAdmin.setAccount(account);
        
        accountRepository.save(account);
        clinicAdmin.setId(account.getId());
        clinicAdminRepository.save(clinicAdmin);

        // When
        clinicAdminRepository.deleteById(clinicAdmin.getId());

        // Then
        assertFalse(accountRepository.existsById(account.getId()));
    }
}
