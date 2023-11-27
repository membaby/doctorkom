package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.SystemUser;

@Mapper
public interface PatientMapper {
    PatientMapper INSTANCE = Mappers.getMapper(PatientMapper.class);


    PatientDTO toDTO(Patient patient);

    default SystemUserDTO systemUserToDTO(SystemUser systemUser){
        return SystemUserMapper.INSTANCE.toDTO(systemUser);
    }

    Patient toEntity(PatientDTO patientDTO);

    default SystemUser systemUserToEntity(SystemUserDTO systemUserDTO){
        return SystemUserMapper.INSTANCE.toEntity(systemUserDTO);
    }

}
