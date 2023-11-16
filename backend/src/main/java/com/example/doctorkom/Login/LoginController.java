package com.example.doctorkom.Login;

import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.AccountDTOMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Entities.Account;

@RestController
public class LoginController {
    
    @PutMapping("/attempt_login")
    public LoginAttemptResponse attemptLogin(@RequestBody AccountDTO accountDTO)
    {
        Account partialAccount = AccountDTOMapper.INSTANCE.toEntity(accountDTO);
        Account fullAccount = new DummyLoginManager().tryLogin(partialAccount);
        return new LoginAttemptResponse(fullAccount != null, fullAccount);
    }

    @PutMapping("/patient_login")
    public PatientDTO patientLogin(AccountDTO account)
    {
        //Get patient entity using account entity
        return null;
    }
    
    @PutMapping("/doctor_login")
    public DoctorDTO doctorLogin(AccountDTO account)
    {
        //Get doctor entity using account entity
        return null;
    }
    
    //Unfinished until system admin entity is implemented
    @PutMapping("/system_admin_login")
    public DoctorDTO systemAdminLogin(AccountDTO account)
    {
        //Get system admin entity using account entity
        return null;
    }
    
    //Unfinished until clinic admin entity is implemented
    @PutMapping("/clinic_admin_login")
    public PatientDTO clinicAdminLogin(AccountDTO account)
    {
        //Get clinic admin entity using account entity
        return null;
    }

    @PutMapping("/recover_password")
    public boolean recoverPassword(@RequestBody String email)
    {
        return new DummyPasswordRecoverer().tryRecoverPassword(email);
    }

}

class DummyLoginManager{
    public Account tryLogin(Account account)
    {
        return null;
    }
}

class DummyPasswordRecoverer{
    public boolean tryRecoverPassword(String email)
    {
        return false;
    }
}

