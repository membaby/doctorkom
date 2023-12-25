package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.MedicalNoteId;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Services.EntityServices.MedicalNoteService;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;

@RestController
@RequestMapping("/medical-note")
public class MedicalNoteController {
    private final MedicalNoteService medicalNoteService;

    public MedicalNoteController(MedicalNoteService medicalNoteService) {
        this.medicalNoteService = medicalNoteService;
    }

    @GetMapping("/{patientId}/{doctorId}/{date}")
    public MedicalNoteDTO getMedicalNote(@PathVariable int patientId, @PathVariable int doctorId, @PathVariable String date) {
        MedicalNoteId medicalNoteId = new MedicalNoteId(
                Patient.builder().id(patientId).build(),
                Doctor.builder().id(doctorId).build(),
                Date.valueOf(date)
        );
        return medicalNoteService.getMedicalNote(medicalNoteId);
    }

    @PostMapping
    public void addMedicalNote(@RequestBody MedicalNoteDTO medicalNoteDTO) {
        medicalNoteService.addMedicalNote(medicalNoteDTO);
    }

    @DeleteMapping("/{patientId}/{doctorId}/{date}")
    public void deleteMedicalNote(@PathVariable int patientId, @PathVariable int doctorId, @PathVariable String date) {
        MedicalNoteId medicalNoteId = new MedicalNoteId(
                Patient.builder().id(patientId).build(),
                Doctor.builder().id(doctorId).build(),
                Date.valueOf(date)
        );
        medicalNoteService.deleteMedicalNote(medicalNoteId);
    }
}
