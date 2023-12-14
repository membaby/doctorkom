package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.Entities.Patient;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface PatientMapper {
    Patient toEntity(PatientDTO patientDTO);

    PatientDTO toDto(Patient patient);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Patient partialUpdate(PatientDTO patientDTO, @MappingTarget Patient patient);
}