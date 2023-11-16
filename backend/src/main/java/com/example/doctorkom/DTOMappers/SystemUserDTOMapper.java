package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.SystemUserDTO;
import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;
import com.example.doctorkom.Entities.SystemUser;

@Mapper
public interface SystemUserDTOMapper {
    SystemUserDTOMapper INSTANCE = Mappers.getMapper(SystemUserDTOMapper.class);

    @Mapping(source = "mobile", target = "mobilePhone")
    @Mapping(source = "landline", target = "landlinePhone")
    SystemUser toEntity(SystemUserDTO userDTO);
    
    default AccountDTO accountToDTO(Account account){
        return AccountDTOMapper.INSTANCE.toDTO(account);
    }
    
    @Mapping(target = "mobile", source = "mobilePhone")
    @Mapping(target = "landline", source = "landlinePhone")
    SystemUserDTO toDTO(SystemUser user);

    default Account accountDTOToAccount(AccountDTO accountDTO){
        return AccountDTOMapper.INSTANCE.toEntity(accountDTO);
    }

}
