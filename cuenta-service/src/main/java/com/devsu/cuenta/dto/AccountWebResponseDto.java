package com.devsu.cuenta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class AccountWebResponseDto {
    private List<TransactionWebResponseDto> transactionList;
}
