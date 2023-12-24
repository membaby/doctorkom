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

    List<TimeSlot> findByDoctorIdAndDate(int doctorId, Date date);

    List<TimeSlot> findByClinicIdAndDate(int clinicId, Date date);

    void deleteByDoctor(Doctor doctor);

    List<TimeSlot> findByDoctorId(Doctor doctor);

    void deleteByClinic(Clinic clinic);

    List<TimeSlot> findByDoctorIdAndClinicIdAndDate(Integer id, Integer id1, Date date);

    List<TimeSlot> findByClinic(Clinic clinic);
}