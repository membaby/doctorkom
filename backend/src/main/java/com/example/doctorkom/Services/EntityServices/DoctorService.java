package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private final DoctorMapper doctorMapper;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorMapper doctorMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.doctorRepository = doctorRepository;
    }

    public DoctorDTO getDoctor(int id) {
        if (doctorRepository.findById(id).isPresent()) {
            return doctorMapper.toDto(doctorRepository.findById(id).get());
        }
        return null;
    }

    public void updateDoctor(DoctorDTO doctorDTO) {
        if (doctorRepository.findById(doctorDTO.getId()).isPresent()) {
            doctorRepository.save(doctorMapper.toEntity(doctorDTO));
        }
    }
}
