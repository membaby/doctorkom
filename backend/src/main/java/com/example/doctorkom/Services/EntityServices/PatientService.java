package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.PatientMapper;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    private final PatientMapper patientMapper;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientMapper patientMapper, PatientRepository patientRepository) {
        this.patientMapper = patientMapper;
        this.patientRepository = patientRepository;
    }

    public PatientDTO getPatient(int id) {
        if (patientRepository.findById(id).isPresent()) {
            return patientMapper.toDto(patientRepository.findById(id).get());
        }
        return null;
    }

    public void updatePatient(PatientDTO patientDTO) {
        if (patientRepository.findById(patientDTO.getId()).isPresent()) {
            patientRepository.save(patientMapper.toEntity(patientDTO));
        }
    }
}
