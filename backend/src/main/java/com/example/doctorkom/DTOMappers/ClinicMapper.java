package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.ClinicDTO;
import com.example.doctorkom.Entities.Clinic;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClinicMapper {
    ClinicMapper INSTANCE = Mappers.getMapper(ClinicMapper.class);

    ClinicDTO toDTO(Clinic clinic);


    Clinic toEntity(ClinicDTO clinicDTO);

}
