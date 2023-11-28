package com.example.doctorkom.Controllers;

import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.*;
import com.example.doctorkom.DTOs.*;
import com.example.doctorkom.Entities.*;

@RestController
public class LoginController {
    
    @PostMapping("/login")
    public LoginResponse attemptLogin(@RequestBody AccountDTO accountDTO)
    {
        Account partialAccount = AccountDTOMapper.INSTANCE.toEntity(accountDTO);
        DummyLoginService loginService = new DummyLoginService();
        Account fullAccount = loginService.login(partialAccount);
        if (fullAccount == null)
            return new LoginResponse(false);

        switch (fullAccount.getRole())
        {
            case PATIENT:
                PatientDTO patientDTO = PatientDTOMapper.INSTANCE.toDTO(loginService.getPatientAccount(fullAccount));
                return new LoginResponse(true, Role.PATIENT, patientDTO);
            case DOCTOR:
                DoctorDTO doctorDTO = DoctorDTOMapper.INSTANCE.toDTO(loginService.getDoctorAccount(fullAccount));
                return new LoginResponse(true, Role.DOCTOR, doctorDTO);
            case SYSTEM_ADMIN:
                SystemAdminDTO systemAdminDTO = SystemAdminDTOMapper.INSTANCE.toDTO(loginService.getSystemAdmin(fullAccount));
                return new LoginResponse(true, Role.SYSTEM_ADMIN, systemAdminDTO);
            default: //CLINIC_ADMIN
                ClinicAdminDTO clinicAdminDTO = ClinicAdminDTOMapper.INSTANCE.toDTO(loginService.getClinicAdmin(fullAccount));
                return new LoginResponse(true, Role.CLINIC_ADMIN, clinicAdminDTO);
        }
    }

    @PostMapping("/recover_password")
    public boolean recoverPassword(@RequestBody String email)
    {
        return new DummyPasswordRecoverer().tryRecoverPassword(email);
    }

}

class DummyLoginService{
    public Account login(Account account)
    {
        return new Account();
    }

    public Patient getPatientAccount(Account account)
    {
        return new Patient();
    }

    public Doctor getDoctorAccount(Account account)
    {
        return new Doctor();
    }

    public SystemAdmin getSystemAdmin(Account account){
        return new SystemAdmin(0);
    }

    public ClinicAdmin getClinicAdmin(Account account){
        return new ClinicAdmin();
    }
}

class DummyPasswordRecoverer{
    public boolean tryRecoverPassword(String email)
    {
        return false;
    }
}

