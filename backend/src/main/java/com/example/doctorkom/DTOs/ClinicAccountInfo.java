package com.example.doctorkom.DTOs;

import lombok.Value;

@Value
public class ClinicAccountInfo {
    private AccountDTO account;
    private ClinicDTO clinic;
}
