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
    private ClinicRepository clinicRepository;

    @Test
    void whenFindClinicById_thenReturnClinic() {
        // Given
        Account account = Account.builder().
                email("nursejane@clinic.com").
                username("NurseJane1").
                password("Healthcare456").
                role(Role.CLINIC_ADMIN).
                build();

        ClinicAdmin clinicAdmin = ClinicAdmin.builder().
                account(account).
                build();

        Clinic clinic = Clinic.builder().
                name("Clinic1").
                address("123 Main St").
                email("Clinic1@org.com").
                mobilePhone("1234567890").
                landlinePhone("(555) 555-5555").
                admin(clinicAdmin).
                build();

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
        Account account = Account.builder().
                email("nursejane@clinic.com").
                username("NurseJane1").
                password("Healthcare456").
                role(Role.CLINIC_ADMIN).
                build();

        ClinicAdmin clinicAdmin = ClinicAdmin.builder().
                account(account).
                build();

        Clinic clinic = Clinic.builder().
                name("Clinic1").
                address("123 Main St").
                email("Clinic1@org.com").
                mobilePhone("1234567890").
                landlinePhone("(555) 555-5555").
                admin(clinicAdmin).
                build();

        clinicRepository.save(clinic);

        // When
        Clinic queriedClinic = null;
        if (!clinicRepository.findByName("Clinic1").isEmpty())
            queriedClinic = clinicRepository.findByName("Clinic1").get(0);

        // Then
        assertEquals(clinic, queriedClinic);
    }
}