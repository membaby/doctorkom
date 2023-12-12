package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.MedicalNoteDTO;
import com.example.doctorkom.Entities.MedicalNote;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MedicalNoteMapper {
    MedicalNote toEntity(MedicalNoteDTO medicalNoteDTO);

    MedicalNoteDTO toDto(MedicalNote medicalNote);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    MedicalNote partialUpdate(MedicalNoteDTO medicalNoteDTO, @MappingTarget MedicalNote medicalNote);
}