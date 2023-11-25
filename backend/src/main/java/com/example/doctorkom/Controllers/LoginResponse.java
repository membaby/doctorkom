package com.example.doctorkom.Controllers;

import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Entities.Role;

public class LoginResponse {
    public boolean success;
    public Role role;
    public PatientDTO patient;
    public DoctorDTO doctor;
    public SystemAdminDTO systemAdmin;
    public ClinicAdminDTO clinicAdmin;

    public LoginResponse(boolean success)
    {
        this.success = success;
    }
    public LoginResponse(boolean success, Role role, PatientDTO patient){
        this.success = success;
        this.role = role;
        this.patient = patient;
    }
    public LoginResponse(boolean success, Role role, DoctorDTO doctor){
        this.success = success;
        this.role = role;
        this.doctor = doctor;
    }
    public LoginResponse(boolean success, Role role, SystemAdminDTO systemAdmin){
        this.success = success;
        this.role = role;
        this.systemAdmin = systemAdmin;
    }
    public LoginResponse(boolean success, Role role, ClinicAdminDTO clinicAdmin){
        this.success = success;
        this.role = role;
        this.clinicAdmin = clinicAdmin;
    }

}
