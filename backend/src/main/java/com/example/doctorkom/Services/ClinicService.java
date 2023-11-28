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
        if (clinic != null &&
                clinic.getAddress() != null &&
                clinic.getEmail() != null &&
                clinic.getPhone() != null &&
                clinic.getLandline() != null &&
                clinic.getName() != null) {

            if(clinicRepository.save(clinic)!=null)
            return "Clinic created successfully";
            else
                return "Creation failed";
        }

        else
            return "Clinic data cannot be null";
    }
    @Transactional
    public String removeClinic(Clinic clinic) {
        //delete by id will do nothing if the id doesnt exist
        if (clinic != null)
        clinicRepository.deleteById(clinic.getId());
        return "Done";
    }

}
