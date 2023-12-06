package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Adder extends Command{


    @Override
    public void executeadd(Patient patient) {
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        Optional<Account> accountOptional = accountRepository.findByEmail(account.getEmail());
        Account newaccount = accountOptional.orElseThrow(() -> new RuntimeException("Account not found"));

        systemUser.setAccount(newaccount);
        systemUser.setId(newaccount.getId());
        systemUserRepository.save(systemUser);

        patient.setSystemUser(systemUser);
        patient.setId(newaccount.getId());
        patientRepository.save(patient);
    }

    @Override
    public void executeadd(Doctor doctor) {
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        Optional<Account> accountOptional = accountRepository.findByEmail(account.getEmail());
        Account newaccount = accountOptional.orElseThrow(() -> new RuntimeException("Account not found"));
        systemUser.setAccount(newaccount);
        systemUser.setId(newaccount.getId());
        systemUserRepository.save(systemUser);

        doctor.setSystemUser(systemUser);
        doctor.setId(newaccount.getId());
        doctorRepository.save(doctor);


    }

    @Override
    public void executeadd(SystemAdmin systemAdmin) {

        Account account = systemAdmin.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        Optional<Account> accountOptional = accountRepository.findByEmail(account.getEmail());
        Account newaccount = accountOptional.orElseThrow(() -> new RuntimeException("Account not found"));
        systemAdmin.setAccount(newaccount);
        systemAdmin.setId(newaccount.getId());
        systemAdminRepository.save(systemAdmin);

    }

    @Override
    public void executeadd(ClinicAdmin clinicAdmin) {
        Account account = clinicAdmin.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        Optional<Account> accountOptional = accountRepository.findByEmail(account.getEmail());
        Account newaccount = accountOptional.orElseThrow(() -> new RuntimeException("Account not found"));
        clinicAdmin.setAccount(newaccount);
        clinicAdmin.setId(newaccount.getId());
        clinicAdminRepository.save(clinicAdmin);

    }

    @Override
    public void executeadd(Verification verification) {
        verificationRepository.save(verification);
    }
    @Override
    public void executeadd(Account account) {
        accountRepository.save(account);
    }
}
