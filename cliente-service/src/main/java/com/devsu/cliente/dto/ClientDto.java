package com.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientDto extends PersonDto{
    private Long id;
    private String password;
    private Boolean status;
}
