package com.devsu.cuenta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionWebResponseDto {
    private String date;
    private String movement;
    private String initialAmount;
    private String finalAmount;
    private String accountNumber;
    private String type;
}
