package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.example.doctorkom.Entities.SystemAdmin}
 */
@Value
@Builder
public class SystemAdminDTO implements Serializable {
    Integer id;
    AccountDTO account;
}