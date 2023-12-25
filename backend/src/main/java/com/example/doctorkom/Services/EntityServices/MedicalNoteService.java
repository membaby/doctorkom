package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.MedicalNoteMapper;
import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.MedicalNote;
import com.example.doctorkom.Entities.MedicalNoteId;
import com.example.doctorkom.Exceptions.MedicalNoteExceptions.MedicalNoteAlreadyExists;
import com.example.doctorkom.Exceptions.MedicalNoteExceptions.MedicalNoteNotFoundException;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.MedicalNoteRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Exceptions.PatientExceptions.PatientNotFoundException;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalNoteService {
    private final MedicalNoteRepository medicalNoteRepository;

    private final PatientRepository patientRepository;

    private final DoctorRepository doctorRepository;

    private final MedicalNoteMapper medicalNoteMapper;

    @Autowired
    public MedicalNoteService(MedicalNoteRepository medicalNoteRepository, PatientRepository patientRepository, DoctorRepository doctorRepository, MedicalNoteMapper medicalNoteMapper) {
        this.medicalNoteRepository = medicalNoteRepository;
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository;
        this.medicalNoteMapper = medicalNoteMapper;
    }

    public MedicalNoteDTO getMedicalNote(MedicalNoteId medicalNoteId) {
        if (medicalNoteRepository.findById(medicalNoteId).isEmpty())
            throw new MedicalNoteNotFoundException();
        return medicalNoteMapper.toDto(medicalNoteRepository.findById(medicalNoteId).get());
    }

    public void addMedicalNote(MedicalNoteDTO medicalNoteDTO) {
        MedicalNote medicalNote = medicalNoteMapper.toEntity(medicalNoteDTO);
        if (patientRepository.findById(medicalNote.getPatient().getId()).isEmpty())
            throw new PatientNotFoundException();
        if (doctorRepository.findById(medicalNote.getDoctor().getId()).isEmpty())
            throw new DoctorNotFoundException();
        MedicalNoteId medicalNoteId = new MedicalNoteId(patientRepository.findById(medicalNote.getPatient().getId()).get(),
                doctorRepository.findById(medicalNote.getDoctor().getId()).get(), medicalNote.getDate());
        if (medicalNoteRepository.findById(medicalNoteId).isPresent())
            throw new MedicalNoteAlreadyExists();
        medicalNote.setId(medicalNoteId);
        System.out.println(medicalNote);
        medicalNoteRepository.save(medicalNote);
    }

    public void deleteMedicalNote(MedicalNoteId medicalNoteId) {
        if (patientRepository.findById(medicalNoteId.getPatient().getId()).isEmpty())
            throw new PatientNotFoundException();
        if (doctorRepository.findById(medicalNoteId.getDoctor().getId()).isEmpty())
            throw new DoctorNotFoundException();
        medicalNoteId = new MedicalNoteId(patientRepository.findById(medicalNoteId.getPatient().getId()).get(),
                doctorRepository.findById(medicalNoteId.getDoctor().getId()).get(), medicalNoteId.getDate());
        if (medicalNoteRepository.findById(medicalNoteId).isEmpty())
            throw new MedicalNoteNotFoundException();
        medicalNoteRepository.deleteById(medicalNoteId);
    }
}
