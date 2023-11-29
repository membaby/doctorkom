package com.example.doctorkom.Services.RepositoryHandler.Commander;

import com.example.doctorkom.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ExistenceChecker extends Command{
    @Autowired
    public ExistenceChecker(AccountRepository accountRepository,
                            PatientRepository patientRepository,
                            DoctorRepository doctorRepository,
                            SystemUserRepository systemUserRepository,
                            ClinicAdminRepository clinicAdminRepository,
                            SystemAdminRepository systemAdminRepository) {
        super(accountRepository, patientRepository, doctorRepository, systemUserRepository, clinicAdminRepository, systemAdminRepository);
    }


    //find if there is an entity with the given attribute
    @Override
    public String execute(String attribute, String type) {
        return switch (type) {
            case "email" -> accountRepository.findByEmail(attribute) != null ? "email already exists" : "";
            case "username" -> accountRepository.findByUsername(attribute) != null ? "username already exists" : "";
            case "id" -> accountRepository.findById(Integer.parseInt(attribute)).isPresent() ? "id already exits" : "";
            default -> null;
        };
    }
    //find if an acccount exits or not



}
