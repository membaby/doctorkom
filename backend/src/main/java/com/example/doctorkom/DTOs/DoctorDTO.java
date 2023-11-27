package com.example.doctorkom.DTOs;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorDTO {
    public int id;
    public String title, specialty;
    public SystemUserDTO systemUser;
}
