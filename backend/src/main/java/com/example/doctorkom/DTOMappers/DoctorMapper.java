package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.SystemUser;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DoctorMapper {
    
    DoctorMapper INSTANCE = Mappers.getMapper(DoctorMapper.class);

    DoctorDTO toDTO(Doctor doctor);

    default SystemUserDTO systemUserToDTO(SystemUser systemUser){
        return SystemUserMapper.INSTANCE.toDTO(systemUser);
    }

    Doctor toEntity(DoctorDTO doctorDTO);

    default SystemUser systemUserToEntity(SystemUserDTO systemUserDTO){
        return SystemUserMapper.INSTANCE.toEntity(systemUserDTO);
    }
}