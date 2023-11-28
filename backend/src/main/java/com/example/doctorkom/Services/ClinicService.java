package com.example.doctorkom.Services;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClinicService {

    private final ClinicRepository clinicRepository;

    @Autowired
    public ClinicService(ClinicRepository clinicRepository) {
        this.clinicRepository = clinicRepository;
    }

    public String createClinic(Clinic clinic) {
           clinicRepository.save(clinic);
           return "Clinic created successfully";
    }
    @Transactional
    public String removeClinic(Clinic clinic) {
        //delete by id will do nothing if the id doesnt exist
        clinicRepository.deleteById(clinic.getId());
        return "Done";
    }

}
