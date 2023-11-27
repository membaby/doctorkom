package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.PatientDTO;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.Patient;
import com.example.doctorkom.Entities.SystemUser;

@Mapper
public interface PatientDTOMapper {
    PatientDTOMapper INSTANCE = Mappers.getMapper(PatientDTOMapper.class);


    PatientDTO toDTO(Patient patient);

    default SystemUserDTO systemUserToDTO(SystemUser systemUser){
        return SystemUserDTOMapper.INSTANCE.toDTO(systemUser);
    }

    Patient toEntity(PatientDTO patientDTO);

    default SystemUser systemUserToEntity(SystemUserDTO systemUserDTO){
        return SystemUserDTOMapper.INSTANCE.toEntity(systemUserDTO);
    }

}
