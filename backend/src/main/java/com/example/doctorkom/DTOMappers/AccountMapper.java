package com.example.doctorkom.DTOMappers;

import com.example.doctorkom.DTOs.AccountDTO;
import com.example.doctorkom.Entities.Account;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface AccountMapper {
    Account toEntity(AccountDTO accountDTO);

    AccountDTO toDto(Account account);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Account partialUpdate(AccountDTO accountDTO, @MappingTarget Account account);
}