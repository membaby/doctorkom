package com.example.doctorkom.Services.RepositoryHandler;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RepositoryHandler {
    private AccountRepository accountRepository;
    private PatientRepository patientRepository;
    private DoctorRepository doctorRepository;
    private SystemUserRepository systemUserRepository;
    private ClinicAdminRepository clinicAdminRepository;
    private SystemAdminRepository systemAdminRepository;

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
    //check if the user exists
    public boolean AccountExists(String email, String username) {
        return EmailAccountExists(email) || UsernameAccountExists(username);
    }
    //add account to database
    public void createAccount(Account account) {
        accountRepository.save(account);
    }
    //add patient to database
    public void createPatient(Patient patient) {
        patientRepository.save(patient);
    }
    //add doctor to database
    public void createDoctor(Doctor doctor) {
        doctorRepository.save(doctor);
    }
    //add SystemUser to database
    public void createSystemUser(SystemUser systemUser) { systemUserRepository.save(systemUser); }
    //aad ClinicAdmin to database
    public void createClinicAdmin(ClinicAdmin clinicAdmin) { clinicAdminRepository.save(clinicAdmin); }
    //add SystemAdmin to database
    public void createSystemAdmin(SystemAdmin systemAdmin) { systemAdminRepository.save(systemAdmin); }
    //--------------------------------------------------------------------------------------------------
    //find doctor by id
    public Doctor findDoctorById(int id) {
        return doctorRepository.findById(id).orElse(null);
    }
    //find system user by id
    public SystemUser findSystemUserById(int id) {
        return systemUserRepository.findById(id).orElse(null);
    }
    private boolean EmailAccountExists(String email) {
        return accountRepository.findByEmail(email) != null;
    }
    private boolean UsernameAccountExists(String username) {
        return accountRepository.findByUsername(username) != null;
    }



}
