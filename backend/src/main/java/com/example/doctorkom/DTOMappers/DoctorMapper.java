package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.DoctorDTO;
import com.example.doctorkom.Entities.Doctor;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DoctorMapper {
    Doctor toEntity(DoctorDTO doctorDTO);

    DoctorDTO toDto(Doctor doctor);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Doctor partialUpdate(DoctorDTO doctorDTO, @MappingTarget Doctor doctor);
}