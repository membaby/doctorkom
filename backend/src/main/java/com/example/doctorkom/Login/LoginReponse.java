package com.example.doctorkom.Login;

import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOs.SystemAdminDTO;
import com.example.doctorkom.Entities.Role;

public class LoginReponse {
    public boolean success;
    public Role role;
    public PatientDTO patient;
    public DoctorDTO doctor;
    public SystemAdminDTO systemAdmin;
    public ClinicAdminDTO clinicAdmin;

    public LoginReponse(boolean success)
    {
        this.success = success;
    }
    public LoginReponse(boolean success, Role role, PatientDTO patient){
        this.success = success;
        this.role = role;
        this.patient = patient;
    }
    public LoginReponse(boolean success, Role role, DoctorDTO doctor){
        this.success = success;
        this.role = role;
        this.doctor = doctor;
    }
    public LoginReponse(boolean success, Role role, SystemAdminDTO systemAdmin){
        this.success = success;
        this.role = role;
        this.systemAdmin = systemAdmin;
    }
    public LoginReponse(boolean success, Role role, ClinicAdminDTO clinicAdmin){
        this.success = success;
        this.role = role;
        this.clinicAdmin = clinicAdmin;
    }

}
