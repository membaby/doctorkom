package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.SystemAdmin;
import com.example.doctorkom.Repositories.*;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class Command {
    protected final AccountRepository accountRepository;
    protected final PatientRepository patientRepository;
    protected final DoctorRepository doctorRepository;
    protected final SystemUserRepository systemUserRepository;
    protected final ClinicAdminRepository clinicAdminRepository;
    protected final SystemAdminRepository systemAdminRepository;

    @Autowired
    public Command(AccountRepository accountRepository,
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

    public void execute() {

    }
    public String execute(String attribute, String type){ return null;};
    public void execute(Patient patient) {
    }
    public void execute(Doctor doctor) {
    }
    public void execute(ClinicAdmin clinicAdmin) {
    }
    public void execute(SystemAdmin systemAdmin) {
    }

    public EntityWrapper execute(String email, String email1, String doctor) {
        return null;
    }
}