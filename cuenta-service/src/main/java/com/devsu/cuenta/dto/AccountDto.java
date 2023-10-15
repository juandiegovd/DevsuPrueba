package com.devsu.cuenta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class AccountDto {
    private Long id;
    private Long clientId;
    private String number;
    private String type;
    private Double amount;
    private Boolean status;
    private String clientDocument;
}
