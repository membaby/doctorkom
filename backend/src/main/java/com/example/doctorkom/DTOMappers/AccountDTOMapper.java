package com.example.doctorkom.DTOMappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;

@Mapper
public interface AccountDTOMapper {
    AccountDTOMapper INSTANCE = Mappers.getMapper(AccountDTOMapper.class);

    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);

}
