package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.MedicalNote;
import com.example.doctorkom.Entities.MedicalNoteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.doctorkom.Entities.Doctor;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface MedicalNoteRepository extends JpaRepository<MedicalNote, MedicalNoteId> {
    List<MedicalNote> findByPatientId(Integer patientId);
    List<MedicalNote> findByDoctorId(Integer doctorId);
    List<MedicalNote> findByDate(Date date);
    List<MedicalNote> findByDoctorIdAndPatientId(Integer doctorId, Integer patientId);
    List<MedicalNote> findByDoctorIdAndDate(Integer doctorId, Date date);
    List<MedicalNote> findByPatientIdAndDate(Integer patientId, Date date);
    Optional<MedicalNote> findByDoctorIdAndPatientIdAndDate(Integer doctorId, Integer patientId, Date date);
    void deleteByPatientId(Integer patientId);
    void deleteByDoctorId(Integer doctorId);
}