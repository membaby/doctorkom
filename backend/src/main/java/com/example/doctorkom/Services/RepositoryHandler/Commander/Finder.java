package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Repositories.*;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Finder extends Command{
    @Autowired
    public Finder(AccountRepository accountRepository,
                  PatientRepository patientRepository,
                  DoctorRepository doctorRepository,
                  SystemUserRepository systemUserRepository,
                  ClinicAdminRepository clinicAdminRepository,
                  SystemAdminRepository systemAdminRepository) {
        super(accountRepository, patientRepository, doctorRepository, systemUserRepository, clinicAdminRepository, systemAdminRepository); }


    //find an entity by id and role

    //find an entity by by attribute and role
    public EntityWrapper execute(String attribute,String type , String role) {
        EntityWrapper entityWrapper = new EntityWrapper();
        switch (type) {
            case "email" -> {
                Account account = accountRepository.findByEmail(attribute);
                if (account != null) {
                    switch (role) {
                        case "patient" -> {
                            Patient patient = patientRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setPatient(patient);
                            entityWrapper.setRole(role);
                        }
                        case "doctor" -> {
                            Doctor doctor = doctorRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setDoctor(doctor);
                            entityWrapper.setRole(role);
                        }
                        case "systemAdmin" -> {
                            SystemAdmin systemAdmin = systemAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setSystemAdmin(systemAdmin);
                            entityWrapper.setRole(role);
                        }
                        case "clinicAdmin" -> {
                            ClinicAdmin clinicAdmin = clinicAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setClinicAdmin(clinicAdmin);
                            entityWrapper.setRole(role);
                        }
                    }
                }
            }
            case "username" -> {
                Account account = accountRepository.findByUsername(attribute);
                if (account != null) {
                    switch (role) {
                        case "patient" -> {
                            Patient patient = patientRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setPatient(patient);
                            entityWrapper.setRole(role);
                        }
                        case "doctor" -> {
                            Doctor doctor = doctorRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setDoctor(doctor);
                            entityWrapper.setRole(role);
                        }
                        case "systemAdmin" -> {
                            SystemAdmin systemAdmin = systemAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setSystemAdmin(systemAdmin);
                            entityWrapper.setRole(role);
                        }
                        case "clinicAdmin" -> {
                            ClinicAdmin clinicAdmin = clinicAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setClinicAdmin(clinicAdmin);
                            entityWrapper.setRole(role);
                        }
                    }
                }
            }
            case "id" -> {
                Account account = accountRepository.findById(Integer.parseInt(attribute)).orElse(null);
                if (account != null) {
                    switch (role) {
                        case "patient" -> {
                            Patient patient = patientRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setPatient(patient);
                            entityWrapper.setRole(role);
                        }
                        case "doctor" -> {
                            Doctor doctor = doctorRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setDoctor(doctor);
                            entityWrapper.setRole(role);
                        }
                        case "systemAdmin" -> {
                            SystemAdmin systemAdmin = systemAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setSystemAdmin(systemAdmin);
                            entityWrapper.setRole(role);
                        }
                        case "clinicAdmin" -> {
                            ClinicAdmin clinicAdmin = clinicAdminRepository.findById(account.getId()).orElse(null);
                            entityWrapper.setClinicAdmin(clinicAdmin);
                            entityWrapper.setRole(role);
                        }
                    }
                }
            }
        }


        return entityWrapper;
    }




    //find an patient by a different attribute

}
