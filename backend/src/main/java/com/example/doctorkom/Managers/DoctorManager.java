package com.example.doctorkom.Managers;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.SystemUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DoctorManager extends SystemUserManager {
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorManager(AccountRepository accountRepository, SystemUserRepository systemUserRepository, DoctorRepository doctorRepository) {
        super(accountRepository, systemUserRepository);
        this.doctorRepository = doctorRepository;
    }

    void addDoctor(Doctor doctor) {
        addSystemUser(doctor.getSystemUser());
        doctor.setId(doctor.getSystemUser().getId());
        doctorRepository.save(doctor);
    }

    void updateDoctor(Doctor doctor) {
        updateSystemUser(doctor.getSystemUser());
    }

    void deleteDoctor(Doctor doctor){
        deleteSystemUser(doctor.getSystemUser());
    }
}
