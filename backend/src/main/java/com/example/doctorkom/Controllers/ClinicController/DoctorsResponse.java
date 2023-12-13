package com.example.doctorkom.Controllers.ClinicController;

import com.example.doctorkom.Entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DoctorsResponse {
    List<Doctor> doctors;
}
