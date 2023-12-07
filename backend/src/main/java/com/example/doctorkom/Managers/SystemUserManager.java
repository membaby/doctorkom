package com.example.doctorkom.Managers;

import com.example.doctorkom.Exceptions.AccountAlreadyExistException;
import com.example.doctorkom.Entities.SystemUser;
import com.example.doctorkom.Exceptions.AccountDoesNotExistException;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SystemUserManager {
    private final AccountRepository accountRepository;
    private final SystemUserRepository systemUserRepository;

    @Autowired
    public SystemUserManager(AccountRepository accountRepository, SystemUserRepository systemUserRepository) {
        this.accountRepository = accountRepository;
        this.systemUserRepository = systemUserRepository;
    }

    void addSystemUser(SystemUser systemUser) {
        if (accountRepository.findByUsername(systemUser.getAccount().getUsername()).isPresent())
            throw new AccountAlreadyExistException("Account already exist");
        accountRepository.save(systemUser.getAccount());
        systemUser.setId(systemUser.getAccount().getId());
        systemUserRepository.save(systemUser);
    }

    void updateSystemUser(SystemUser systemUser) {
        if (accountRepository.findByUsername(systemUser.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        systemUserRepository.save(systemUser);
    }

    void deleteSystemUser(SystemUser systemUser) {
        if (accountRepository.findByUsername(systemUser.getAccount().getUsername()).isEmpty())
            throw new AccountDoesNotExistException("Account doesn't exist");
        accountRepository.deleteByUsername(systemUser.getAccount().getUsername());
    }
}
