package com.devsu.cliente.facade;

import com.devsu.cliente.dto.ClientReportDto;
import com.devsu.cliente.dto.ClientWebReportDto;
import com.devsu.cliente.service.ReportService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ReportFacade {
    private final ReportService reportService;
    public ReportFacade(ReportService reportService){
        this.reportService = reportService;
    }

    public List<ClientWebReportDto> getClientReport(LocalDate startDate, LocalDate endDate, String documentNumber){
        return completeReport(reportService.getClientReport(startDate, endDate, documentNumber));
    }

    private List<ClientWebReportDto> completeReport(ClientReportDto clientReportDto){
        List<ClientWebReportDto> report = new ArrayList<>();
        for (var transactions: clientReportDto.getTransactionDtoList()){
            ClientWebReportDto row = new ClientWebReportDto();
            row.setDate(transactions.getDate());
            row.setName(clientReportDto.getClientDto().getName());
            row.setStatus(clientReportDto.getClientDto().getStatus().toString());
            row.setAccountNumber(transactions.getAccountNumber());
            row.setFinalAmount(transactions.getFinalAmount());
            row.setInitialAmount(transactions.getInitialAmount());
            row.setMovement(transactions.getMovement());
            row.setAccountType(transactions.getType());

            report.add(row);
        }
        return report;
    }
}
