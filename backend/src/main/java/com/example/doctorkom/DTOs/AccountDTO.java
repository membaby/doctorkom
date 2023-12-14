package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Account}
 */
@Value
@Builder
public class AccountDTO implements Serializable {
    Integer id;
    String email;
    String username;
    String password;
    Role role;
}