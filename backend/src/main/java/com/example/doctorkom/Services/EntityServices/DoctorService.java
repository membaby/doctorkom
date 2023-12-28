package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.ClinicMapper;
import com.example.doctorkom.DTOMappers.DoctorMapper;
import com.example.doctorkom.DTOMappers.MedicalNoteMapper;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.DoctorSpecialty;
import com.example.doctorkom.Entities.DoctorTitle;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import com.example.doctorkom.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class DoctorService {
    private static final int PAGE_SIZE = 10;
    private final DoctorMapper doctorMapper;
    private final ClinicMapper clinicMapper;
    private final MedicalNoteMapper medicalNoteMapper;
    private final DoctorRepository doctorRepository;

    @Autowired
    public DoctorService(DoctorMapper doctorMapper, ClinicMapper clinicMapper, MedicalNoteMapper medicalNoteMapper, DoctorRepository doctorRepository) {
        this.doctorMapper = doctorMapper;
        this.clinicMapper = clinicMapper;
        this.medicalNoteMapper = medicalNoteMapper;
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

    public Page<DoctorDTO> findAllDoctors(Specification<Doctor> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        Page<Doctor> doctors = doctorRepository.findAll(specification, pageable);
        return doctors.map(doctorMapper::toDto);
    }

    public Page<DoctorDTO> findAllDoctors(String name, String city, DoctorSpecialty specialty, DoctorTitle title, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, PAGE_SIZE);
        Page<Doctor> doctors = doctorRepository.findAllDoctorsWithDoctorAndClinic(name, city, specialty, title, pageable);
        return doctors.map(doctorMapper::toDto);
    }

    public List<ClinicDTO> getDoctorClinics(int doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty())
            throw new DoctorNotFoundException();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return doctor.getClinics().stream().map(clinicMapper::toDto).toList();
    }

    public List<MedicalNoteDTO> getDoctorMedicalNotes(int doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty())
            throw new DoctorNotFoundException();
        Doctor doctor = doctorRepository.findById(doctorId).get();
        return doctor.getMedicalNotes().stream().map(medicalNoteMapper::toDto).toList();
    }
}
