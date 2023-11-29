package com.example.doctorkom.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.*;
import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Entities.*;
import com.example.doctorkom.Services.Register_LogIn.LogInService;
import com.example.doctorkom.Services.RepositoryHandler.EntityWrapper;

@RestController
public class LoginController {

    @Autowired
    AccountMapper accountMapper;
    @Autowired
    PatientMapper patientMapper;
    @Autowired
    DoctorMapper doctorMapper;
    @Autowired
    SystemAdminMapper systemAdminMapper;
    @Autowired
    ClinicAdminMapper clinicAdminMapper;
    @Autowired
    LogInService logInService;
    
    @PostMapping("/login")
    public LoginResponse attemptLogin(@RequestBody AccountDTO accountDTO)
    {
        
        Account partialAccount = accountMapper.toEntity(accountDTO);
        EntityWrapper fullAccount = logInService.login(partialAccount);
        if (fullAccount == null)
            return new LoginResponse(false);

        switch (fullAccount.getRole())
        {
            case "PATIENT":
                PatientDTO patientDTO = patientMapper.toDTO(fullAccount.getPatient());
                return new LoginResponse(true, Role.PATIENT, patientDTO);
            case "DOCTOR":
                DoctorDTO doctorDTO = doctorMapper.toDTO(fullAccount.getDoctor());
                return new LoginResponse(true, Role.DOCTOR, doctorDTO);
            case "SYSTEM_ADMIN":
                SystemAdminDTO systemAdminDTO = systemAdminMapper.toDTO(fullAccount.getSystemAdmin());
                return new LoginResponse(true, Role.SYSTEM_ADMIN, systemAdminDTO);
            default: //CLINIC_ADMIN
                ClinicAdminDTO clinicAdminDTO = clinicAdminMapper.toDTO(fullAccount.getClinicAdmin());
                return new LoginResponse(true, Role.CLINIC_ADMIN, clinicAdminDTO);
        }
    }

    @PostMapping("/recover_password")
    public boolean recoverPassword(@RequestBody String email)
    {
        return new DummyPasswordRecoverer().tryRecoverPassword(email);
    }

}

class DummyPasswordRecoverer{
    public boolean tryRecoverPassword(String email)
    {
        return false;
    }
}
