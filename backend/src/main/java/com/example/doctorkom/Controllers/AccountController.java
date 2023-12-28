package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Services.EntityServices.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
public class AccountController {
    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PutMapping
    public void updateAccount(@RequestBody AccountDTO accountDTO) {
        accountService.updateAccount(accountDTO);
    }

    @DeleteMapping("/{username}")
    public void deleteAccount(@PathVariable String username) {
        accountService.deleteAccount(username);
    }
}
