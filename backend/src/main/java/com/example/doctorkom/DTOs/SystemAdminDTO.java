package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

/**
 * DTO for {@link com.example.doctorkom.Entities.SystemAdmin}
 */
@Value
@Builder
public class SystemAdminDTO {
    Integer id;
    AccountDTO account;
}