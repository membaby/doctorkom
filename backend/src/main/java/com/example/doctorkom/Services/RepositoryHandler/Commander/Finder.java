package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;
import org.springframework.stereotype.Component;

@Component
public class Finder extends Command{
    
    //find an entity by id and role

    //find an entity by by attribute and role
    @Override
    public EntityWrapper executefind(String attribute,String type , String role) {
        EntityWrapper entityWrapper = new EntityWrapper();
        switch (type) {
            case "email" -> {
                Account account = accountRepository.findByEmail(attribute).orElse(null);
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
                Account account = accountRepository.findByUsername(attribute).orElse(null);
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
    @Override
    public Verification executefind(Account account) {
        //find verification by account
        //find account by email
        account = accountRepository.findByEmail(account.getEmail()).orElse(null);
        if (account == null) return null;
        //find verification by account id
        Verification verification = verificationRepository.findById(account.getId()).orElse(null);
        return verification;
    }
    @Override
    public Account executefind(String email) {
        //find account by email
        Account account = accountRepository.findByEmail(email).get();
        return account;
    }




    //find an patient by a different attribute

}
