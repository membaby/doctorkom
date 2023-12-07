package com.example.doctorkom.Managers;

import com.example.doctorkom.Entities.SystemAdmin;
import com.example.doctorkom.Exceptions.AccountAlreadyExistException;
import com.example.doctorkom.Exceptions.AccountDoesNotExistException;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.SystemAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemAdminManager {
    private final AccountRepository accountRepository;
    private final SystemAdminRepository systemAdminRepository;

    @Autowired
    public SystemAdminManager(AccountRepository accountRepository, SystemAdminRepository systemAdminRepository) {
        this.accountRepository = accountRepository;
        this.systemAdminRepository = systemAdminRepository;
    }

    void addSystemAdmin(SystemAdmin systemAdmin) {
        if (accountRepository.findByUsername(systemAdmin.getAccount().getUsername()).isPresent())
            throw new AccountAlreadyExistException("Account already exist");
        accountRepository.save(systemAdmin.getAccount());
        systemAdmin.setId(systemAdmin.getAccount().getId());
        systemAdminRepository.save(systemAdmin);
    }

    void updateSystemAdmin(SystemAdmin systemAdmin) {
        if (accountRepository.findByUsername(systemAdmin.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        systemAdminRepository.save(systemAdmin);
    }

    void deleteSystemAdmin(SystemAdmin systemAdmin) {
        if (accountRepository.findByUsername(systemAdmin.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        accountRepository.deleteByUsername(systemAdmin.getAccount().getUsername());
    }
}
