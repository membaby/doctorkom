package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.ClinicAdminDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.ClinicAdmin;


@Mapper
public interface ClinicAdminDTOMapper {
    
    ClinicAdminDTOMapper INSTANCE = Mappers.getMapper(ClinicAdminDTOMapper.class);

    ClinicAdminDTO toDTO(ClinicAdmin clinicAdmin);

    default AccountDTO AccountToDTO(Account account){
        return AccountDTOMapper.INSTANCE.toDTO(account);
    }

    ClinicAdmin toEntity(ClinicAdminDTO clinicAdminDTO);

    default Account AccountToEntity(AccountDTO accountDTO){
        return AccountDTOMapper.INSTANCE.toEntity(accountDTO);
    }
}
