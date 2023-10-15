package com.devsu.cliente.service;

import com.devsu.cliente.client.TransactionEsbClient;
import com.devsu.cliente.dto.ClientReportDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


@RequiredArgsConstructor
@Service
public class ReportServiceImpl implements ReportService{
    private final ClientService clientService;
    private final TransactionEsbClient accountEsbClient;

    @Override
    public ClientReportDto getClientReport(LocalDate startDate, LocalDate endDate, String documentNumber) {
        var client = clientService.getClient(documentNumber);
        var transactionList = accountEsbClient.getAccountWithTransactions(startDate, endDate, client.getId());
        var clientReport = new ClientReportDto();
        clientReport.setClientDto(client);
        clientReport.setTransactionDtoList(transactionList);
        return clientReport;
    }
}
