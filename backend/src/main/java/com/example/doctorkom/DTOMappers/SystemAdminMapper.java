package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.SystemAdminDTO;
import com.example.doctorkom.Entities.SystemAdmin;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SystemAdminMapper {
    SystemAdmin toEntity(SystemAdminDTO systemAdminDto);

    SystemAdminDTO toDto(SystemAdmin systemAdmin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SystemAdmin partialUpdate(SystemAdminDTO systemAdminDto, @MappingTarget SystemAdmin systemAdmin);
}