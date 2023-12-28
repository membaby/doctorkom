package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Entities.TimeSlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, TimeSlotId> {

    List<TimeSlot> findAllByDoctorIdAndDate(Integer doctorId, Date date);

    List<TimeSlot> findAllByClinicIdAndDate(Integer clinicId, Date date);

    void deleteByDoctor(Doctor doctor);

    List<TimeSlot> findAllByDoctorId(Integer doctorId);

    void deleteByClinic(Clinic clinic);

    List<TimeSlot> findAllByDoctorIdAndClinicIdAndDate(Integer id, Integer id1, Date date);

    List<TimeSlot> findAllByClinic(Clinic clinic);
}