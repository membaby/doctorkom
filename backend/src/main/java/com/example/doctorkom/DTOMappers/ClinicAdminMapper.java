package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.ClinicAdmin;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ClinicAdminMapper {
    
    ClinicAdminMapper INSTANCE = Mappers.getMapper(ClinicAdminMapper.class);

    ClinicAdminDTO toDTO(ClinicAdmin clinicAdmin);

    default AccountDTO AccountToDTO(Account account){
        return AccountMapper.INSTANCE.toDTO(account);
    }

    ClinicAdmin toEntity(ClinicAdminDTO clinicAdminDTO);

    default Account AccountToEntity(AccountDTO accountDTO){
        return AccountMapper.INSTANCE.toEntity(accountDTO);
    }
}
