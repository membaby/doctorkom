package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.Role;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Account}
 */
@Getter
public class AccountDTO implements Serializable {
    Integer id;
    public String email;
    String username;
    public String password;
    Role role;
}