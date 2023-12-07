package com.example.doctorkom.Managers;

import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Exceptions.AccountAlreadyExistException;
import com.example.doctorkom.Exceptions.AccountDoesNotExistException;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.ClinicAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ClinicAdminManager {
    private final AccountRepository accountRepository;
    private final ClinicAdminRepository clinicAdminRepository;

    @Autowired
    public ClinicAdminManager(AccountRepository accountRepository, ClinicAdminRepository clinicAdminRepository) {
        this.accountRepository = accountRepository;
        this.clinicAdminRepository = clinicAdminRepository;
    }

    void addClinicAdmin(ClinicAdmin clinicAdmin) {
        if (accountRepository.findByUsername(clinicAdmin.getAccount().getUsername()).isPresent())
            throw new AccountAlreadyExistException("Account already exist");
        accountRepository.save(clinicAdmin.getAccount());
        clinicAdmin.setId(clinicAdmin.getAccount().getId());
        clinicAdminRepository.save(clinicAdmin);
    }

    void updateClinicAdmin(ClinicAdmin clinicAdmin) {
        if (accountRepository.findByUsername(clinicAdmin.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        clinicAdminRepository.save(clinicAdmin);
    }

    void deleteClinicAdmin(ClinicAdmin clinicAdmin) {
        if (accountRepository.findByUsername(clinicAdmin.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        accountRepository.deleteByUsername(clinicAdmin.getAccount().getUsername());
    }
}
