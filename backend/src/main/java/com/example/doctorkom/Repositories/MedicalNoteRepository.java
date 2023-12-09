package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.MedicalNote;
import com.example.doctorkom.Entities.MedicalNoteId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface MedicalNoteRepository extends JpaRepository<MedicalNote, MedicalNoteId> {
    // Retrieve by patientId
    List<MedicalNote> findByPatientId(Integer patientId);
    // Retrieve by doctorId
    List<MedicalNote> findByDoctorId(Integer doctorId);
    // Retrieve by date
    List<MedicalNote> findByDate(Date date);
    // Retrieve by doctorId and patientId
    List<MedicalNote> findByDoctorIdAndPatientId(Integer doctorId, Integer patientId);
    // Retrieve by doctorId and date
    List<MedicalNote> findByDoctorIdAndDate(Integer doctorId, Date date);
    // Retrieve by patientId and date
    List<MedicalNote> findByPatientIdAndDate(Integer patientId, Date date);
    // Retrieve by doctorId, patientId, and date
    Optional<MedicalNote> findByDoctorIdAndPatientIdAndDate(Integer doctorId, Integer patientId, Date date);
    // Delete by patientId
    void deleteByPatientId(Integer patientId);
    // Delete by doctorId
    void deleteByDoctorId(Integer doctorId);
    // Delete by doctorId
    void deleteByDoctor(Doctor doctor);
}