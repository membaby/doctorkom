package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.SystemUser;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface SystemUserMapper {
    SystemUser toEntity(SystemUserDTO systemUserDTO);

    SystemUserDTO toDto(SystemUser systemUser);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    SystemUser partialUpdate(SystemUserDTO systemUserDTO, @MappingTarget SystemUser systemUser);
}