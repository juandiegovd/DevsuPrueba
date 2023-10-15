package com.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientWebReportDto {
    private String date;
    private String name;
    private String accountNumber;
    private String accountType;
    private String initialAmount;
    private String status;
    private String movement;
    private String finalAmount;
}
