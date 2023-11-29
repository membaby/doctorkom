package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Deleter extends Command{
    @Autowired
    public Deleter(
            AccountRepository accountRepository,
            PatientRepository patientRepository,
            DoctorRepository doctorRepository,
            SystemUserRepository systemUserRepository,
            ClinicAdminRepository clinicAdminRepository,
            SystemAdminRepository systemAdminRepository,
            VerificationRepository verificationRepository) {
        super(accountRepository, patientRepository, doctorRepository, systemUserRepository, clinicAdminRepository, systemAdminRepository, verificationRepository);
    }
    @Override
    public void executedelete(Patient patient) {
        SystemUser systemUser = patient.getSystemUser();
        Account account = systemUser.getAccount();
        patientRepository.delete(patient);
        systemUserRepository.delete(systemUser);
        accountRepository.delete(account);
    }
    @Override
    public void executedelete(Doctor doctor) {
        SystemUser systemUser = doctor.getSystemUser();
        Account account = systemUser.getAccount();
        doctorRepository.delete(doctor);
        systemUserRepository.delete(systemUser);
        accountRepository.delete(account);
    }
    @Override
    public void executedelete(ClinicAdmin clinicAdmin) {
        Account account = clinicAdmin.getAccount();
        clinicAdminRepository.delete(clinicAdmin);
        accountRepository.delete(account);
    }
    @Override
    public void executedelete(SystemAdmin systemAdmin) {
        Account account = systemAdmin.getAccount();
        systemAdminRepository.delete(systemAdmin);
        accountRepository.delete(account);
    }
    @Override
    public void executedelete(Verification verification) {
        verificationRepository.delete(verification);
    }
    @Override
    public void executedelete(Account account) {
        accountRepository.delete(account);
    }

}