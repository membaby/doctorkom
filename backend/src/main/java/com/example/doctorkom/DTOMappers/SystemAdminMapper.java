package com.example.doctorkom.DTOMappers;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.DTOs.SystemAdminDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.SystemAdmin;

@Mapper
public interface SystemAdminMapper {
     
    SystemAdminMapper INSTANCE = Mappers.getMapper(SystemAdminMapper.class);

    SystemAdminDTO toDTO(SystemAdmin systemAdmin);

    default AccountDTO AccountToDTO(Account account){
        return AccountMapper.INSTANCE.toDTO(account);
    }

    SystemAdmin toEntity(SystemAdminDTO systemAdminDTO);

    default Account AccountToEntity(AccountDTO accountDTO){
        return AccountMapper.INSTANCE.toEntity(accountDTO);
    }
}
