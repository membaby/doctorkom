package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.example.doctorkom.DTOMappers.AccountMapper;
import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Services.Register_LogIn.RegistrationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AdminController {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    RegistrationService regService;

    @PostMapping("/create-clinic")
    public String createClinic(@RequestBody AccountDTO accountDto)
    {
        Account account = accountMapper.toEntity(accountDto);
        DummyAdminTools dummyAdminTools = new DummyAdminTools();
        String msg = dummyAdminTools.registerClinic(account);
        return msg;
    }

    @PostMapping("/remove-clinic")
    public String removeClinic(@RequestBody String email)
    {
        DummyAdminTools dummyAdminTools = new DummyAdminTools();
        String msg = dummyAdminTools.removeClinic(email);
        return msg;
    }
    
}



class DummyAdminTools{


    public String registerClinic(Account account){
        return "";
    }

    public String removeClinic(String email){
        return "";
    }
}