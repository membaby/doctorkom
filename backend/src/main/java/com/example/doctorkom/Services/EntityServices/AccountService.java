package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService {
    private final AccountMapper accountMapper;
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountMapper accountMapper, AccountRepository accountRepository) {
        this.accountMapper = accountMapper;
        this.accountRepository = accountRepository;
    }

    public AccountDTO getAccount(String username) {
        if (accountRepository.findByUsername(username).isPresent()) {
            return accountMapper.toDto(accountRepository.findByUsername(username).get());
        }
        return null;
    }

    public void updateAccount(AccountDTO accountDTO) {
        if (accountRepository.findByUsername(accountDTO.getUsername()).isPresent()) {
            Account account = accountRepository.findByUsername(accountDTO.getUsername()).get();
            accountRepository.save(accountMapper.partialUpdate(accountDTO, account));
        }
    }

    public boolean existAccount(String username) {
        return accountRepository.findByUsername(username).isPresent();
    }
}
