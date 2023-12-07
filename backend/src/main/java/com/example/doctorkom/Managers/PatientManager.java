package com.example.doctorkom.Managers;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class PatientManager extends SystemUserManager {
    private final PatientRepository patientRepository;

    @Autowired
    public PatientManager(AccountRepository accountRepository, SystemUserRepository systemUserRepository, PatientRepository patientRepository) {
        super(accountRepository, systemUserRepository);
        this.patientRepository = patientRepository;
    }

    void addPatient(Patient patient) {
        addSystemUser(patient.getSystemUser());
        patient.setId(patient.getSystemUser().getId());
        patientRepository.save(patient);
    }

    void updatePatient(Patient patient) {
        updateSystemUser(patient.getSystemUser());
    }

    void deletePatient(Patient patient){
        deleteSystemUser(patient.getSystemUser());
    }
}
