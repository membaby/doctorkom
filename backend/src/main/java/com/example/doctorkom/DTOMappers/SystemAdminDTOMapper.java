package com.example.doctorkom.DTOMappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.SystemAdminDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.SystemAdmin;

@Mapper
public interface SystemAdminDTOMapper {
     
    SystemAdminDTOMapper INSTANCE = Mappers.getMapper(SystemAdminDTOMapper.class);

    SystemAdminDTO toDTO(SystemAdmin systemAdmin);

    default AccountDTO AccountToDTO(Account account){
        return AccountDTOMapper.INSTANCE.toDTO(account);
    }

    SystemAdmin toEntity(SystemAdminDTO systemAdminDTO);

    default Account AccountToEntity(AccountDTO accountDTO){
        return AccountDTOMapper.INSTANCE.toEntity(accountDTO);
    }
}
