package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, TimeSlotId> {

    List<TimeSlot> findByDoctorIdAndDate(Integer doctorId, Date date);

    List<TimeSlot> findByClinicIdAndDate(Integer clinicId, Date date);

    List<TimeSlot> findAllByDoctorIdAndDate(Integer doctorId, Date date);

    List<TimeSlot> findAllByClinicIdAndDate(Integer clinicId, Date date);

    void deleteByDoctor(Doctor doctor);

    List<TimeSlot> findAllByDoctorId(Integer doctorId);

    void deleteByClinic(Clinic clinic);

    List<TimeSlot> findAllByDoctorIdAndClinicIdAndDate(Integer id, Integer id1, Date date);

    List<TimeSlot> findByClinic(Clinic clinic);

    List<TimeSlot> findAllByDoctorIdAndClinicIdOrderByDateAscStartTimeAsc(Integer doctorId, Integer clinicId);
  
    List<TimeSlot> findAllByClinic(Clinic clinic);
}