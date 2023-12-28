package com.example.doctorkom.Services.DashboardServices;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Services.EntityServices.AppointmentService;
import com.example.doctorkom.Services.EntityServices.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class DoctorDashboardService {
    private final DoctorService doctorService;
    private final AppointmentService appointmentService;

    @Autowired
    public DoctorDashboardService(DoctorService doctorService, AppointmentService appointmentService) {
        this.doctorService = doctorService;
        this.appointmentService = appointmentService;
    }

    public Page<AppointmentDTO> getDoctorAppointments(int doctorId, int pageCount) {
        return appointmentService.getDoctorAppointments(doctorId, pageCount);
    }
}
