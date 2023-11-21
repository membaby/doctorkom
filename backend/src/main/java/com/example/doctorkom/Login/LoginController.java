package com.example.doctorkom.Login;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.AccountDTOMapper;
import com.example.doctorkom.DTOMappers.DoctorDTOMapper;
import com.example.doctorkom.DTOMappers.PatientDTOMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Role;

@RestController
public class LoginController {
    
    @PutMapping("/login")
    public LoginReponse attemptLogin(@RequestBody AccountDTO accountDTO)
    {
        Account partialAccount = AccountDTOMapper.INSTANCE.toEntity(accountDTO);
        DummyLoginService loginService = new DummyLoginService();
        Account fullAccount = loginService.login(partialAccount);
        if (fullAccount == null)
            return new LoginReponse(false);

        switch (fullAccount.getRole())
        {
            case PATIENT:
                PatientDTO patientDTO = PatientDTOMapper.INSTANCE.toDTO(loginService.getPatientAccount(fullAccount));
                return new LoginReponse(true, Role.PATIENT, patientDTO);

            case DOCTOR:
                DoctorDTO doctorDTO = DoctorDTOMapper.INSTANCE.toDTO(loginService.getDoctorAccount(fullAccount));
                return new LoginReponse(true, Role.DOCTOR, doctorDTO);
            
            case SYSTEM_ADMIN:
            
            default: //CLINIC_ADMIN
        }
        
    }

    @PutMapping("/recover_password")
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

    
}

class DummyPasswordRecoverer{
    public boolean tryRecoverPassword(String email)
    {
        return false;
    }
}

