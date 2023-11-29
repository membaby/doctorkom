package com.example.doctorkom.Services.Register_LogIn;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.ClinicAdminRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Repositories.SystemAdminRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LogInService {
    
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    SystemUserRepository systemUserRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DoctorRepository doctorRepository;
    @Autowired
    SystemAdminRepository systemAdminRepository;
    @Autowired
    ClinicAdminRepository clinicAdminRepository;


    public EntityWrapper login(Account account) {
        //check if the user exists
        Account fullAccount = accountRepository.findByEmail(account.getEmail()).orElse(null);
        if (fullAccount == null)
            fullAccount = accountRepository.findByUsername(account.getUsername()).orElse(null);
        
        if (fullAccount == null)
            return null;
        else
        {
            if (!fullAccount.isEnabled()) return null;
            return getAccountDetails(fullAccount);
        }
    }

    private EntityWrapper getAccountDetails(Account account) {
        EntityWrapper wrapper = new EntityWrapper();
        wrapper.setRole(account.getRole().toString());
        switch (account.getRole()) {
            case PATIENT:
                wrapper.setPatient(patientRepository.findById(account.getId()).orElse(null));
                break;
            case DOCTOR:
                wrapper.setDoctor(doctorRepository.findById(account.getId()).orElse(null));
                break;
            case SYSTEM_ADMIN:
                wrapper.setSystemAdmin(systemAdminRepository.findById(account.getId()).orElse(null));
                break;
            case CLINIC_ADMIN:
                wrapper.setClinicAdmin(clinicAdminRepository.findById(account.getId()).orElse(null));
                break;
        }
        return wrapper;
    }
}

