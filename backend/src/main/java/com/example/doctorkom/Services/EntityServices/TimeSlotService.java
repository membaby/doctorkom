package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;
    private final TimeSlotMapper timeSlotsMapper;
    private final DoctorRepository doctorRepository;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository, TimeSlotMapper timeSlotsMapper,
                           DoctorRepository doctorRepository) {
        this.timeSlotRepository = timeSlotRepository;
        this.timeSlotsMapper = timeSlotsMapper;
        this.doctorRepository = doctorRepository;
    }

    public List<TimeSlotDTO> getDoctorTimeSlots(int doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty())
            throw new DoctorNotFoundException();
        List<TimeSlot> timeSlots = timeSlotRepository.findAllByDoctorId(doctorId);
        return timeSlots.stream().map(timeSlotsMapper::toDto).toList();
    }
}
