package com.devsu.cuenta.mapper;

import com.devsu.cuenta.dto.AccountDto;
import com.devsu.cuenta.entity.AccountEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface AccountMapper {
    AccountMapper MAPPER = Mappers.getMapper(AccountMapper.class);
    @Mapping(source = "number", target = "number")
    @Mapping(source = "amount", target = "firstAmount")
    @Mapping(source = "status", target = "status")
    @Mapping(source = "type", target = "type")
    @Mapping(target = "id", ignore = true)
    AccountEntity toAccountEntity(AccountDto accountDto);

    @InheritInverseConfiguration
    @Mapping(source = "id", target = "id")
    AccountDto toAccountDto(AccountEntity accountEntity);
}
