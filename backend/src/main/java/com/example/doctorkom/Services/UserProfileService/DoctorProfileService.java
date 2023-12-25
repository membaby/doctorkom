package com.example.doctorkom.Services.UserProfileService;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Services.EntityServices.AccountService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorProfileService implements UserProfileService<DoctorDTO> {
    private final AccountService accountService;
    private final DoctorService doctorService;

    @Autowired
    public DoctorProfileService(AccountService accountService, DoctorService doctorService) {
        this.accountService = accountService;
        this.doctorService = doctorService;
    }

    @Override
    public DoctorDTO getUserProfile(String username) {
        if (accountService.existAccount(username)) {
            return doctorService.getDoctor(accountService.getAccount(username).getId());
        }
        return null;
    }

    @Override
    public void updateUserProfile(DoctorDTO userProfile) {
        doctorService.updateDoctor(userProfile);
    }
}