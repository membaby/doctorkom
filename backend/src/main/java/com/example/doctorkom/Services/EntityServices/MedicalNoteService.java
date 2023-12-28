package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.MedicalNoteMapper;
import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.MedicalNote;
import com.example.doctorkom.Entities.MedicalNoteId;
import com.example.doctorkom.Exceptions.MedicalNoteExceptions.MedicalNoteAlreadyExists;
import com.example.doctorkom.Exceptions.MedicalNoteExceptions.MedicalNoteNotFoundException;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.MedicalNoteRepository;
import com.example.doctorkom.Repositories.PatientRepository;
import com.example.doctorkom.Exceptions.PatientExceptions.PatientNotFoundException;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import com.example.doctorkom.Exceptions.MedicalNoteException.MedicalNoteAlreadyExistsException;
import com.example.doctorkom.Repositories.MedicalNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalNoteService {
    private static final int PAGE_SIZE = 10;
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

    public Page<MedicalNoteDTO> getAllMedicalNotes(int doctorId, int pageCount) {
        Pageable page = PageRequest.of(pageCount, PAGE_SIZE);
        if (medicalNoteRepository.findAllByDoctorId(doctorId, page).isEmpty())
            throw new MedicalNoteNotFoundException();
        Page<MedicalNote> medicalNotes = medicalNoteRepository.findAllByDoctorId(doctorId, page);
        return medicalNotes.map(medicalNoteMapper::toDto);
    }

    public void addMedicalNote(MedicalNoteDTO medicalNoteDTO) {
        MedicalNote medicalNote = medicalNoteMapper.toEntity(medicalNoteDTO);
        if (patientRepository.findById(medicalNote.getPatient().getId()).isEmpty())
            throw new PatientNotFoundException();
        Optional<Doctor> existingDoctor = doctorRepository.findById(medicalNote.getDoctor().getId());
        if (existingDoctor.isEmpty())
            throw new DoctorNotFoundException();
        MedicalNoteId medicalNoteId = new MedicalNoteId(patientRepository.findById(medicalNote.getPatient().getId()).get(),
                doctorRepository.findById(medicalNote.getDoctor().getId()).get(), medicalNote.getDate());
        if (medicalNoteRepository.findById(medicalNoteId).isPresent())
            throw new MedicalNoteAlreadyExists();
        medicalNote.setId(medicalNoteId);
        medicalNote.setDoctor(existingDoctor.get());
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
