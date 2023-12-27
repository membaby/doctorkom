package com.example.doctorkom.Services.DashboardServices;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Entities.Appointment;
import com.example.doctorkom.Services.EntityServices.AppointmentService;
import com.example.doctorkom.Services.EntityServices.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class PatientDashboardService {
    private final PatientService patientService;

    private final AppointmentService appointmentService;

    @Autowired
    public PatientDashboardService(PatientService patientService, AppointmentService appointmentService) {
        this.patientService = patientService;
        this.appointmentService = appointmentService;
    }

    public Page<AppointmentDTO> getPatientAppointments(int patientId, int pageCount) {
        return appointmentService.getPatientAppointments(patientId, pageCount);
    }
}
