package com.example.doctorkom.DTOs;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SystemUserDTO {
    public int id;
    public String firstName, lastName, address, mobile, landline, gender;
    public Date birthdate;
    public AccountDTO account;
}
