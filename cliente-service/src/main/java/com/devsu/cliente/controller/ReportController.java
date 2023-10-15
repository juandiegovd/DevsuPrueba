package com.devsu.cliente.controller;

import com.devsu.cliente.dto.ClientWebReportDto;
import com.devsu.cliente.dto.ReportWebRequestDto;
import com.devsu.cliente.facade.ReportFacade;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportes")
public class ReportController {
    private final ReportFacade reportFacade;

    public ReportController(ReportFacade reportFacade){
        this.reportFacade = reportFacade;
    }
    @PostMapping
    public List<ClientWebReportDto> getClientReportDto(
            @RequestBody ReportWebRequestDto reportWebRequestDto){
        return reportFacade.getClientReport(reportWebRequestDto.getStartDate(), reportWebRequestDto.getFinalDate(), reportWebRequestDto.getDocumentNumber());
    }
}
