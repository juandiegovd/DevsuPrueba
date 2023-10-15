package com.devsu.cliente.service;

import com.devsu.cliente.dto.ClientReportDto;

import java.time.LocalDate;

public interface ReportService {
    ClientReportDto getClientReport(LocalDate startDate, LocalDate endDate, String documentNumber);
}
