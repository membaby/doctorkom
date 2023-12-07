package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Entities.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ActiveProfiles("test")
@DataJpaTest
class ClinicRepositoryTest {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ClinicAdminRepository clinicAdminRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Test
    void whenFindClinicById_thenReturnClinic() {
        // Given
        Account account = new Account("nursejane@clinic.com", "NurseJane1", "Healthcare456", Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        Clinic clinic = new Clinic("Clinic1", "123 Main St", "Clinic1@org.com", "1234567890", "(555) 555-5555", clinicAdmin);
        clinicAdmin.setAccount(account);
        clinic.setAdmin(clinicAdmin);

        accountRepository.save(account);
        clinicAdmin.setId(account.getId());
        clinicAdminRepository.save(clinicAdmin);
        clinic.setId(clinicAdmin.getId());
        clinicRepository.save(clinic);


        // When
        Clinic queriedClinic = null;
        if (clinicRepository.findById(clinic.getId()).isPresent())
            queriedClinic = clinicRepository.findById(clinic.getId()).get();

        // Then
        assertEquals(clinic, queriedClinic);
    }

    @Test
    void whenFindClinicsByName_thenReturnClinics() {
        // Given
        Account account = new Account("nursejane@clinic.com", "NurseJane1", "Healthcare456", Role.CLINIC_ADMIN);
        ClinicAdmin clinicAdmin = new ClinicAdmin();
        Clinic clinic = new Clinic("Clinic1@org.com", "Clinic1", "123 Main St", "1234567890", "(555) 555-5555", clinicAdmin);
        clinicAdmin.setAccount(account);
        clinic.setAdmin(clinicAdmin);

        accountRepository.save(account);
        clinicAdmin.setId(account.getId());
        clinicAdminRepository.save(clinicAdmin);
        clinic.setId(clinicAdmin.getId());
        clinicRepository.save(clinic);


        // When
        Clinic queriedClinic = null;
        if (clinicRepository.findByName("Clinic1").isPresent())
            queriedClinic = clinicRepository.findByName("Clinic1").get().get(0);

        // Then
        assertEquals(clinic, queriedClinic);
    }
}