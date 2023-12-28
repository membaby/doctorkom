package com.example.doctorkom.Services.DashboardServices;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Services.EntityServices.AppointmentService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import com.example.doctorkom.Services.EntityServices.MedicalNoteService;
import com.example.doctorkom.Services.EntityServices.TimeSlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorDashboardService {
    private final DoctorService doctorService;
    private final TimeSlotService timeSlotService;
    private final AppointmentService appointmentService;
    private final MedicalNoteService medicalNoteService;

    @Autowired
    public DoctorDashboardService(DoctorService doctorService, AppointmentService appointmentService, TimeSlotService timeSlotService, MedicalNoteService medicalNoteService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
        this.timeSlotService = timeSlotService;
        this.medicalNoteService = medicalNoteService;
    }

    public List<AppointmentDTO> getDoctorAppointments(int doctorId) {
        return appointmentService.getDoctorAppointments(doctorId);
    }

    public List<TimeSlotDTO> getDoctorTimeSlots(int doctorId) {
        return timeSlotService.getDoctorTimeSlots(doctorId);
    }

    public List<ClinicDTO> getDoctorClinics(int doctorId) {
        return doctorService.getDoctorClinics(doctorId);
    }

    public List<MedicalNoteDTO> getDoctorMedicalNotes(int doctorId) {
        return doctorService.getDoctorMedicalNotes(doctorId);
    }

    public void addMedicalNote(MedicalNoteDTO medicalNoteDTO) {
        medicalNoteService.addMedicalNote(medicalNoteDTO);
    }

    public void deleteAppointment(AppointmentDTO appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
    }
}
