package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class Command {
    protected final AccountRepository accountRepository;
    protected final PatientRepository patientRepository;
    protected final DoctorRepository doctorRepository;
    protected final SystemUserRepository systemUserRepository;
    protected final ClinicAdminRepository clinicAdminRepository;
    protected final SystemAdminRepository systemAdminRepository;
    protected final VerificationRepository verificationRepository;

    @Autowired
    public Command(AccountRepository accountRepository,
                             PatientRepository patientRepository,
                             DoctorRepository doctorRepository,
                             SystemUserRepository systemUserRepository,
                             ClinicAdminRepository clinicAdminRepository,
                             SystemAdminRepository systemAdminRepository,
                             VerificationRepository verificationRepository) {
        this.accountRepository = accountRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.systemUserRepository = systemUserRepository;
        this.clinicAdminRepository = clinicAdminRepository;
        this.systemAdminRepository = systemAdminRepository;
        this.verificationRepository = verificationRepository;
    }

    public void execute() {

    }
    //ExistenceChecker
    public String executecheck(String attribute, String type){ return null;}
    //adder
    public void executeadd(Patient patient) {
    }
    public void executeadd(Doctor doctor) {
    }
    public void executeadd(ClinicAdmin clinicAdmin) {
    }
    public void executeadd(SystemAdmin systemAdmin) {
    }
    public void executeadd(Verification verification){
    }
    //finder
    public EntityWrapper executefind(String email, String email1, String Role) {
        return null;
    }
    public Verification executefind(Account account){
        return null;
    }
    //deleter
    public void executedelete(Patient patient) {
    }
    public void executedelete(Doctor doctor) {
    }
    public void executedelete(ClinicAdmin clinicAdmin) {
    }
    public void executedelete(SystemAdmin systemAdmin) {
    }
    public void executedelete(Verification verification){
    }
}