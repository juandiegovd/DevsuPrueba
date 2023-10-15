package com.devsu.cuenta.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ClientWebResponseDto {
    private Boolean status;
    private String documentNumber;
    private String name;
    private String gender;
    private String age;
    private String address;
    private String phone;
    private Long id;
}
