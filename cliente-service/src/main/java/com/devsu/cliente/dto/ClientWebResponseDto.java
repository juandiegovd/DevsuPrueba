package com.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientWebResponseDto extends PersonDto{
    private int id;
    private Boolean status;
}
