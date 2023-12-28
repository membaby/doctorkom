package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.MedicalNoteMapper;
import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.MedicalNote;
import com.example.doctorkom.Exceptions.MedicalNoteException.MedicalNoteAlreadyExistsException;
import com.example.doctorkom.Repositories.MedicalNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalNoteService {
    private final MedicalNoteRepository medicalNoteRepository;

    private final MedicalNoteMapper medicalNoteMapper;

    @Autowired
    public MedicalNoteService(MedicalNoteRepository medicalNoteRepository, MedicalNoteMapper medicalNoteMapper) {
        this.medicalNoteRepository = medicalNoteRepository;
        this.medicalNoteMapper = medicalNoteMapper;
    }

    public void addMedicalNote(MedicalNoteDTO medicalNoteDTO) {
        MedicalNote medicalNote = medicalNoteMapper.toEntity(medicalNoteDTO);
        if (medicalNoteRepository.findById(medicalNote.getId()).isPresent())
            throw new MedicalNoteAlreadyExistsException();
        medicalNoteRepository.save(medicalNote);
    }
}
