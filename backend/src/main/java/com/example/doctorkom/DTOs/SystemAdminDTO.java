package com.example.doctorkom.DTOs;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.SystemAdmin}
 */
@Value
public class SystemAdminDTO implements Serializable {
    Integer id;
    AccountDTO account;
}