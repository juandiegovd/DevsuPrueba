package com.devsu.cuenta.facade;

import com.devsu.cuenta.dto.TransactionDto;
import com.devsu.cuenta.dto.TransactionWebResponseDto;
import com.devsu.cuenta.mapper.TransactionMapper;
import com.devsu.cuenta.service.TransactionService;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class TransactionFacade {
    private final TransactionService transactionService;
    public TransactionFacade(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    public TransactionDto createTransaction(TransactionDto transactionDto){
        return transactionService.createTransaction(transactionDto);
    }

    public List<TransactionWebResponseDto> getTransactionListBetweenDates(Long id, LocalDate startDate, LocalDate endDate){
        return TransactionMapper.MAPPER.toTransactionWebResponseDtoList(transactionService.getTransactionListBetweenDates(id, startDate, endDate));
    }
}
