package com.devsu.cuenta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class TransactionDto {
    private String accountNumber;
    private String type;
    private Double amount;
    private Double finalAmount;
    private LocalDateTime createdOn;
    private AccountDto accountDto;
}
