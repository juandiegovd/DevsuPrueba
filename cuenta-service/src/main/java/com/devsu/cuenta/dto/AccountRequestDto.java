package com.devsu.cuenta.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class AccountRequestDto {
    private String documentNumber;
    private int id;
}
