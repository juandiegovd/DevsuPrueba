package com.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;


@Getter
@Setter
@ToString
public class ClientReportDto {
    private ClientDto clientDto;
    private List<TransactionResponseDto> transactionDtoList;
}
