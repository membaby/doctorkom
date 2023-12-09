package com.example.doctorkom.Services.UserProfileService;

import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Services.EntityServices.AccountService;
import com.example.doctorkom.Services.EntityServices.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientProfileService implements UserProfileService<PatientDTO> {
    private final AccountService accountService;
    private final PatientService patientService;

    @Autowired
    public PatientProfileService(AccountService accountService, PatientService patientService) {
        this.accountService = accountService;
        this.patientService = patientService;
    }

    @Override
    public PatientDTO getUserProfile(String username) {
        if (accountService.existAccount(username)) {
            return patientService.getPatient(accountService.getAccount(username).getId());
        }
        return null;
    }

    @Override
    public void updateUserProfile(PatientDTO patientProfile) {
        patientService.updatePatient(patientProfile);
    }
}