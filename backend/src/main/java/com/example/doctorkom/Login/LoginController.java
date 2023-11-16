package com.example.doctorkom.Login;

import org.springframework.web.bind.annotation.*;

import com.example.doctorkom.DTOMappers.AccountDTOMapper;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;

@RestController
public class LoginController {
    
    @PutMapping("/login")
    public LoginReponse login(@RequestBody AccountDTO accountDTO)
    {
        Account account = AccountDTOMapper.INSTANCE.toEntity(accountDTO);
        String msg = new DummyLoginManager().tryLogin(account);
        boolean success = msg.isEmpty();
        return new LoginReponse(success, msg);
    }

    @PutMapping("/recover_password")
    public boolean recoverPassword(@RequestBody String email)
    {
        return new DummyPasswordRecoverer().tryRecoverPassword(email);
    }

}

class DummyLoginManager{
    public String tryLogin(Account account)
    {
        return "";
    }
}

class DummyPasswordRecoverer{
    public boolean tryRecoverPassword(String email)
    {
        return false;
    }
}


class LoginReponse{
    public boolean success;
    public String message;

    public LoginReponse(boolean success, String message){
        this.success = success;
        this.message = message;
    }
}