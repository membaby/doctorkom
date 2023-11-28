package com.example.doctorkom.Services.RepositoryHandler;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {
    private final AccountRepository accountRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final SystemUserRepository systemUserRepository;
    private final ClinicAdminRepository clinicAdminRepository;
    private final SystemAdminRepository systemAdminRepository;

    @Autowired
    public RepositoryHandler(AccountRepository accountRepository,
                             PatientRepository patientRepository,
                             DoctorRepository doctorRepository,
                             SystemUserRepository systemUserRepository,
                             ClinicAdminRepository clinicAdminRepository,
                             SystemAdminRepository systemAdminRepository) {
        this.accountRepository = accountRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.systemUserRepository = systemUserRepository;
        this.clinicAdminRepository = clinicAdminRepository;
        this.systemAdminRepository = systemAdminRepository;
    }
    //add account to database
    public void AddAccount(Account account) {
        accountRepository.save(account);
    }
    //add patient to database
    public void AddPatient(Patient patient) {
        patientRepository.save(patient);
    }
    //add doctor to database
    public void AddDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    //add SystemUser to database
    public void AddSystemUser(SystemUser systemUser) { systemUserRepository.save(systemUser); }
    //aad ClinicAdmin to database
    public void AddClinicAdmin(ClinicAdmin clinicAdmin) { clinicAdminRepository.save(clinicAdmin); }
    //add SystemAdmin to database
    public void AddSystemAdmin(SystemAdmin systemAdmin) { systemAdminRepository.save(systemAdmin); }
    //--------------------------------------------------------------------------------------------------
    //find system user by id
    public SystemUser findSystemUserById(int id) {
        return systemUserRepository.findById(id).orElse(null);
    }
    public boolean EmailAccountExists(String email) {
        return accountRepository.findByEmail(email) != null;
    }
    public boolean UsernameAccountExists(String username) {
        return accountRepository.findByUsername(username) != null;
    }



}
