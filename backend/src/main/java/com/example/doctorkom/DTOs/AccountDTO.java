package com.example.doctorkom.DTOs;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccountDTO {
    public String email, password, username;
    public String role;
    public int id;
}
