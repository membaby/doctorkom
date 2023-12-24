package com.example.doctorkom.Services.AdminTools;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Repositories.ClinicRepository;

import jakarta.transaction.Transactional;

@Service
public class ClinicManagementService {
    
    @Autowired
    ClinicRepository clinicRepo;
    public final String CREATE_SUCCESS = "Clinic created successfully";
    public final String CONTACT_EMAIL_EXISTS = "This contact email is already used"; 
    public final String REMOVE_SUCCESS = "Clinic removed successfully";
    public final String NOT_FOUND = "Clinic removed successfully";

    public String createClinic(Clinic clinic) {
       if( clinicRepo.findByEmail(clinic.getEmail()) == null) {
           clinicRepo.save(clinic);
           return CREATE_SUCCESS;
       }
       else{
           return CONTACT_EMAIL_EXISTS;
       }
    }


    @Transactional
    public String removeClinic(Clinic clinic) {
        Optional<Clinic> existingClinic = clinicRepo.findByEmail(clinic.getEmail());
        if (existingClinic.isPresent()) {
            clinicRepo.deleteByEmail(existingClinic.get().getEmail());
            return REMOVE_SUCCESS;
        } else {
            return NOT_FOUND;
        }
    }

    public Page<Clinic> findAllClinics(Specification<Clinic> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 10);
        return clinicRepo.findAll(specification, pageable);
    }

}
