package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.Entities.Clinic;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClinicMapper {
    Clinic toEntity(ClinicDTO clinicDTO);

    ClinicDTO toDto(Clinic clinic);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Clinic partialUpdate(ClinicDTO clinicDTO, @MappingTarget Clinic clinic);
}