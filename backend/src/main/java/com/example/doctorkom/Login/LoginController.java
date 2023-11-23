package com.example.doctorkom.Login;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.AccountDTOMapper;
import com.example.doctorkom.DTOMappers.ClinicAdminDTOMapper;
import com.example.doctorkom.DTOMappers.DoctorDTOMapper;
import com.example.doctorkom.DTOMappers.PatientDTOMapper;
import com.example.doctorkom.DTOMappers.SystemAdminDTOMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOs.SystemAdminDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.ClinicAdmin;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.Role;
import com.example.doctorkom.Entities.SystemAdmin;

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
                SystemAdminDTO systemAdminDTO = SystemAdminDTOMapper.INSTANCE.toDTO(loginService.getSystemAdmin(fullAccount));
                return new LoginReponse(true, Role.SYSTEM_ADMIN, systemAdminDTO);
            default: //CLINIC_ADMIN
                ClinicAdminDTO clinicAdminDTO = ClinicAdminDTOMapper.INSTANCE.toDTO(loginService.getClinicAdmin(fullAccount));
                return new LoginReponse(true, Role.SYSTEM_ADMIN, clinicAdminDTO);
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

