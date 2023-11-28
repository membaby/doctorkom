package com.example.doctorkom.DTOs;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientDTO {
    public int id;
    public String maritalStatus, occupation, insurance;
    public SystemUserDTO systemUser;
}
