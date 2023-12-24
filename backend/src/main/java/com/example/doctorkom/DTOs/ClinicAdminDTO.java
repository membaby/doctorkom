package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;
/**
 * DTO for {@link com.example.doctorkom.Entities.ClinicAdmin}
 */
@Value
@Builder
public class ClinicAdminDTO {
    Integer id;
    AccountDTO account;
}