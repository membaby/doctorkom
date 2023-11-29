package com.example.doctorkom.Services;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public String createClinic(Clinic clinic) {
       if( clinicRepository.findByEmail(clinic.getEmail()) == null) {
           clinicRepository.save(clinic);
           return "Clinic created successfully";
       }
       else{
           return "Clinic already on ";
       }
    }
    @Transactional
    public String removeClinic(Clinic clinic) {
        Clinic existingClinic = clinicRepository.findByEmail(clinic.getEmail());
        if (existingClinic != null) {
            clinicRepository.deleteByEmail(existingClinic.getEmail());
            return "Clinic removed successfully";
        } else {
            return "Clinic not found";
        }
    }
}
