package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.AppointmentDTO;
import com.example.doctorkom.Entities.Appointment;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AppointmentMapper {
    Appointment toEntity(AppointmentDTO appointmentDTO);
    AppointmentDTO toDto(Appointment appointment);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Appointment partialUpdate(AppointmentDTO appointmentDTO,@MappingTarget Appointment appointment);
}
