package com.example.doctorkom.Repositories;

import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Entities.TimeSlotId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, TimeSlotId> {
}