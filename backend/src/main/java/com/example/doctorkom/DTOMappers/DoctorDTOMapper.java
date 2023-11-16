package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.Entities.Doctor;
import com.example.doctorkom.Entities.SystemUser;


@Mapper
public interface DoctorDTOMapper {
    
    DoctorDTOMapper INSTANCE = Mappers.getMapper(DoctorDTOMapper.class);

    DoctorDTO toDTO(Doctor doctor);

    default SystemUserDTO systemUserToDTO(SystemUser systemUser){
        return SystemUserDTOMapper.INSTANCE.toDTO(systemUser);
    }

    Doctor toEntity(DoctorDTO doctorDTO);

    default SystemUser systemUserToEntity(SystemUserDTO systemUserDTO){
        return SystemUserDTOMapper.INSTANCE.toEntity(systemUserDTO);
    }
}
