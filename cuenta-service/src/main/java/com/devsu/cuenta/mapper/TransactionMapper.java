package com.devsu.cuenta.mapper;

import com.devsu.cuenta.dto.TransactionDto;
import com.devsu.cuenta.dto.TransactionWebResponseDto;
import com.devsu.cuenta.entity.TransactionEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper
public interface TransactionMapper {
    TransactionMapper MAPPER = Mappers.getMapper(TransactionMapper.class);

    @Mapping(source = "type", target = "type")
    @Mapping(source = "amount", target = "movement")
    @Mapping(source = "accountDto.type", target = "accountEntity.type")
    @Mapping(source = "accountDto.id", target = "accountEntity.id")
    @Mapping(source = "accountDto.number", target = "accountEntity.number")
    @Mapping(target = "id", ignore = true)
    TransactionEntity toTransactionEntity(TransactionDto transactionDto);

    @InheritInverseConfiguration
    @Mapping(source = "finalAmount", target = "finalAmount")
    TransactionDto toTransactionDto(TransactionEntity transactionEntity);
    List<TransactionDto> toTransactionDtoList(List<TransactionEntity> transactionEntityList);

    @Mapping(source = "accountDto.number", target = "accountNumber")
    @Mapping(source = "accountDto.type", target = "type")
    @Mapping(source = "finalAmount", target = "finalAmount")
    @Mapping(source = "amount", target = "movement")
    TransactionWebResponseDto toTransactionWebDto(TransactionDto transactionDto);
    List<TransactionWebResponseDto> toTransactionWebResponseDtoList(List<TransactionDto> transactionDtoList);

    @AfterMapping
    default TransactionWebResponseDto afterTransactionWebDto(@MappingTarget TransactionWebResponseDto transactionWebResponseDto, TransactionDto transactionDto){
        Double initialAmount = transactionDto.getFinalAmount()-transactionDto.getAmount();
        transactionWebResponseDto.setInitialAmount(initialAmount.toString());
        transactionWebResponseDto.setDate(transactionDto.getCreatedOn().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));

        return transactionWebResponseDto;
    }
}
