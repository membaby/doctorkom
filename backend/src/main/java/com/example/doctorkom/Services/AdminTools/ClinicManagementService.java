package com.example.doctorkom.Services.AdminTools;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Clinic;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Repositories.AccountRepository;
import com.example.doctorkom.Repositories.ClinicRepository;

import jakarta.transaction.Transactional;

@Service
public class ClinicManagementService {
    
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ClinicRepository clinicRepo;

    public final String REMOVE_SUCCESS = "Clinic removed successfully";
    public final String NON_EXISTANT = "No clinic exists with this account email";


    @Transactional
    public String removeClinic(String accountEmail) 
    {
        Optional<Account> existingAccount = accountRepository.findByEmail(accountEmail);
        if (existingAccount.isEmpty() || existingAccount.get().getRole() != Role.CLINIC_ADMIN)
        {
            return NON_EXISTANT;
        }
        else
        {
            accountRepository.deleteById(existingAccount.get().getId());
            return REMOVE_SUCCESS;
        }
        
    }

    public Page<Clinic> findAllClinics(Specification<Clinic> specification, int pageCount) {
        Pageable pageable = PageRequest.of(pageCount, 10);
        return clinicRepo.findAll(specification, pageable);
    }

}
