package com.devsu.cliente.mapper;

import com.devsu.cliente.dto.ClientDto;
import com.devsu.cliente.dto.ClientWebResponseDto;
import com.devsu.cliente.entity.ClientEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ClientMapper {
    ClientMapper MAPPER = Mappers.getMapper(ClientMapper.class);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "name", target = "personEntity.name")
    @Mapping(source = "address", target = "personEntity.address")
    @Mapping(source = "password", target = "password")
    @Mapping(source = "age", target = "personEntity.age")
    @Mapping(source = "gender", target = "personEntity.gender")
    @Mapping(source = "phone", target = "personEntity.phone")
    @Mapping(source = "documentNumber", target = "personEntity.documentNumber")
    @Mapping(target = "id", ignore = true)
    ClientEntity toClientEntity(ClientDto clientDto);

    @InheritInverseConfiguration
    @Mapping(source = "id", target = "id")
    ClientDto toClientDto(ClientEntity clientEntity);

    @Mapping(source = "status", target = "status")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "address", target = "address")
    @Mapping(source = "age", target = "age")
    @Mapping(source = "gender", target = "gender")
    @Mapping(source = "phone", target = "phone")
    @Mapping(source = "documentNumber", target = "documentNumber")
    @Mapping(source = "id", target = "id")
    ClientWebResponseDto toClientWebResponseDto(ClientDto clientDto);

}
