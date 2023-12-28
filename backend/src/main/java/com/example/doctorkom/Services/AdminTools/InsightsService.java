package com.example.doctorkom.Services.AdminTools;

import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.AppointmentRepository;
import com.example.doctorkom.Repositories.ClinicRepository;
import com.example.doctorkom.Repositories.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;

@Service
public class InsightsService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private ClinicRepository clinicRepository;

    @Autowired
    private AppointmentRepository appointmentRepository;

    public HashMap<String, Integer> getTotalRowCounts() {
        long accountCount = accountRepository.count();
        long doctorCount = doctorRepository.count();
        long clinicCount = clinicRepository.count();
        long appointmentCount = appointmentRepository.count();

        HashMap<String, Integer> counts = new HashMap<>();
        counts.put("totalAccounts", (int) accountCount);
        counts.put("totalDoctors", (int) doctorCount);
        counts.put("totalClinics", (int) clinicCount);
        counts.put("totalAppointments", (int) appointmentCount);

        return counts;
    }
}