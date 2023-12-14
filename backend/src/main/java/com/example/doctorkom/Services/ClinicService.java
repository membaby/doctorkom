package com.example.doctorkom.Services;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicService {

    @Autowired
    private ClinicRepository clinicRepository;


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
        Optional<Clinic> existingClinic = clinicRepository.findByEmail(clinic.getEmail());
        if (existingClinic.isPresent()) {
            clinicRepository.deleteByEmail(existingClinic.get().getEmail());
            return "Clinic removed successfully";
        } else {
            return "Clinic not found";
        }
    }
}
