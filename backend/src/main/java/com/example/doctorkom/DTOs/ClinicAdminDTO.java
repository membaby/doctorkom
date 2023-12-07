package com.example.doctorkom.DTOs;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.ClinicAdmin}
 */
@Value
public class ClinicAdminDTO implements Serializable {
    Integer id;
    AccountDTO account;
}