package com.example.doctorkom.Services.EntityServices;

import com.example.doctorkom.DTOMappers.TimeSlotMapper;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.TimeSlot;
import com.example.doctorkom.Exceptions.DoctorExceptions.DoctorNotFoundException;
import com.example.doctorkom.Repositories.DoctorRepository;
import com.example.doctorkom.Repositories.TimeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TimeSlotService {
    private final TimeSlotRepository timeSlotRepository;
    private final DoctorRepository doctorRepository;
    private final TimeSlotMapper timeSlotMapper;

    @Autowired
    public TimeSlotService(TimeSlotRepository timeSlotRepository, DoctorRepository doctorRepository, TimeSlotMapper timeSlotMapper) {
        this.timeSlotRepository = timeSlotRepository;
        this.doctorRepository = doctorRepository;
        this.timeSlotMapper = timeSlotMapper;
    }

    public List<Object> getTimeSlotsByDoctorId(int doctorId) {
        if (doctorRepository.findById(doctorId).isEmpty())
            throw new DoctorNotFoundException();
        List<Object> clinicTimeSlots = new ArrayList<>();
        List<Clinic> clinics = doctorRepository.findById(doctorId).get().getClinics();
        for (Clinic clinic : clinics) {
            clinic.setTimeSlots(null);
            clinic.setDoctors(null);
            List<TimeSlot> timeSlots = timeSlotRepository.findAllByDoctorIdAndClinicIdOrderByDateAscStartTimeAsc(doctorId, clinic.getId());
            clinicTimeSlots.add(Map.of("clinic", clinic, "timeSlots", timeSlots.stream().peek(timeSlot -> {
                timeSlot.setDoctor(null);
                timeSlot.setClinic(null);
            }).map(timeSlotMapper::toDto).collect(Collectors.toList())));
        }
        return clinicTimeSlots;
    }
}
