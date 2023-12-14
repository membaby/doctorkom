package com.example.doctorkom.DTOs;

import lombok.Builder;
import lombok.Value;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * DTO for {@link com.example.doctorkom.Entities.Verification}
 */
@Value
@Builder
public class VerificationDTO implements Serializable {
    Integer id;
    String code;
    LocalDateTime expirationTime;
    AccountDTO account;
}