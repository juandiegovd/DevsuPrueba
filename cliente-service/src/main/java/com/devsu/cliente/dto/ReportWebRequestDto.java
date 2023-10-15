package com.devsu.cliente.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public class ReportWebRequestDto {
    private LocalDate startDate;
    private LocalDate finalDate;
    private String documentNumber;
}
