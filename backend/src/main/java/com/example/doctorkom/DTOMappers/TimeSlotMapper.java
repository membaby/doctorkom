package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.TimeSlotDTO;
import com.example.doctorkom.Entities.TimeSlot;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface TimeSlotMapper {
    TimeSlot toEntity(TimeSlotDTO timeSlotDto);

    TimeSlotDTO toDto(TimeSlot timeSlot);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    TimeSlot partialUpdate(TimeSlotDTO timeSlotDto, @MappingTarget TimeSlot timeSlot);
}