package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Entities.TimeSlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, TimeSlotId> {
    List<TimeSlot> findByDoctorId(Integer doctorId);
    List<TimeSlot> findByClinicId(Integer clinicId);
    List<TimeSlot> findByDate(java.sql.Date date);
    List<TimeSlot> findByDoctorIdAndClinicId(Integer doctorId, Integer clinicId);
    List<TimeSlot> findByDoctorIdAndDate(Integer doctorId, java.sql.Date date);
    List<TimeSlot> findByClinicIdAndDate(Integer clinicId, java.sql.Date date);
    Optional<TimeSlot> findByDoctorIdAndClinicIdAndDate(Integer doctorId, Integer clinicId, java.sql.Date date);
    void deleteByDoctorId(Integer doctorId);
    void deleteByClinicId(Integer clinicId);
}