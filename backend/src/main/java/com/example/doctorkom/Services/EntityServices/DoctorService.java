package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.Repositories.DoctorRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

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
            Doctor doctor = doctorRepository.findById(doctorDTO.getId()).get();
            doctorRepository.save(doctorMapper.partialUpdate(doctorDTO, doctor));
        }
    }

    public List<Doctor> findAllDoctors(Specification<Doctor> specification) {
        return doctorRepository.findAll(specification);
    }

    public List<Doctor> findAllDoctors(String name, String city, DoctorSpecialty specialty, DoctorTitle title) {
        return doctorRepository.findAllDoctorsWithDoctorAndClinic(name, city, specialty, title);
    }
}
