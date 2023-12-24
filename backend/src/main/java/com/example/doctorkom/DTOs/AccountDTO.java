package com.example.doctorkom.DTOs;

import com.example.doctorkom.Entities.Role;
import lombok.Builder;
import lombok.Data;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.Account}
 */
@Builder
@Value
public class AccountDTO {
    Integer id;
    String email;
    String username;
    String password;
    Role role;
}