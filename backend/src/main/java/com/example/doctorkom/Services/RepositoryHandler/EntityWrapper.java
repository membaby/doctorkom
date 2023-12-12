package com.example.doctorkom.Services.RepositoryHandler;

import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.SystemAdmin;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class EntityWrapper {
    //this class is used to wrap the entity and return it
    private Patient patient;
    private Doctor doctor;
    private SystemAdmin systemAdmin;
    private ClinicAdmin clinicAdmin;
    private String role;
}
