package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Adder extends Command{
    @Autowired
    public Adder(AccountRepository accountRepository,
                 PatientRepository patientRepository,
                 DoctorRepository doctorRepository,
                 SystemUserRepository systemUserRepository,
                 ClinicAdminRepository clinicAdminRepository,
                 SystemAdminRepository systemAdminRepository) {
        super(accountRepository, patientRepository, doctorRepository, systemUserRepository, clinicAdminRepository, systemAdminRepository);
    }







    public void execute(Patient patient) {
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        account = accountRepository.findByEmail(account.getEmail());

        systemUser.setAccount(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        patient.setSystemUser(systemUser);
        patient.setId(account.getId());
        patientRepository.save(patient);
    }


    public void execute(Doctor doctor) {
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        account = accountRepository.findByEmail(account.getEmail());

        systemUser.setAccount(account);
        systemUser.setId(account.getId());
        systemUserRepository.save(systemUser);

        doctor.setSystemUser(systemUser);
        doctor.setId(account.getId());
        doctorRepository.save(doctor);

    }


    public void execute(SystemAdmin systemAdmin) {

        Account account = systemAdmin.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        account = accountRepository.findByEmail(account.getEmail());
        systemAdmin.setAccount(account);
        systemAdmin.setAccountID(account.getId());

        systemAdminRepository.save(systemAdmin);
    }

    public void execute(ClinicAdmin clinicAdmin) {
        Account account = clinicAdmin.getAccount();
        accountRepository.save(account);
        //get the generated id by the database after saving the account
        account = accountRepository.findByEmail(account.getEmail());
        clinicAdmin.setAccount(account);
        clinicAdmin.setAccountID(account.getId());

        clinicAdminRepository.save(clinicAdmin);
    }
}
