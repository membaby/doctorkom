package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.Entities.ClinicAdmin;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClinicAdminMapper {
    ClinicAdmin toEntity(ClinicAdminDTO clinicAdminDTO);

    ClinicAdminDTO toDto(ClinicAdmin clinicAdmin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ClinicAdmin partialUpdate(ClinicAdminDTO clinicAdminDTO, @MappingTarget ClinicAdmin clinicAdmin);
}