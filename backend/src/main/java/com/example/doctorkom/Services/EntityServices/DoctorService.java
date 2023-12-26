package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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
            Doctor doctor = doctorRepository.findById(doctorDTO.getId()).get();
            doctorRepository.save(doctorMapper.partialUpdate(doctorDTO, doctor));
        }
    }

    public Page<Doctor> findAllDoctors(Specification<Doctor> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 10);
        return doctorRepository.findAll(specification, pageable);
    }

    public Page<Doctor> findAllDoctors(String name, String city, DoctorSpecialty specialty, DoctorTitle title, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 10);
        System.out.println("name: " + name + " city: " + city + " specialty: " + specialty + " title: " + title);
        return doctorRepository.findAllDoctorsWithDoctorAndClinic(name, city, specialty, title, pageable);
    }
}
