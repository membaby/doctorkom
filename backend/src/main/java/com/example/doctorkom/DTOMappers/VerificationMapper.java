package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.VerificationDTO;
import com.example.doctorkom.Entities.Verification;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface VerificationMapper {
    Verification toEntity(VerificationDTO verificationDto);

    VerificationDTO toDto(Verification verification);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Verification partialUpdate(VerificationDTO verificationDto, @MappingTarget Verification verification);
}