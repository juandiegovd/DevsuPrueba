package com.devsu.cuenta.controller;

import com.devsu.cuenta.dto.TransactionDto;
import com.devsu.cuenta.dto.TransactionWebResponseDto;
import com.devsu.cuenta.facade.TransactionFacade;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/movimientos")
public class TransactionController {
    private final TransactionFacade transactionFacade;
    public TransactionController(TransactionFacade transactionFacade){
        this.transactionFacade = transactionFacade;
    }

    @PostMapping("")
    public TransactionDto createTransaction(@RequestBody TransactionDto transactionDto){
        return transactionFacade.createTransaction(transactionDto);
    }


    @GetMapping
    public List<TransactionWebResponseDto> getAccountWithTransactions(@RequestParam(value = "startDate")
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate,
                                                                      @RequestParam(value = "finalDate")
                                                            @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate finalDate, @RequestParam("id") Long clientId){
        return transactionFacade.getTransactionListBetweenDates(clientId, startDate, finalDate);
    }
}
