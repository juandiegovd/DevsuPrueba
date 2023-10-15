package com.devsu.cuenta.service;

import com.devsu.cuenta.dto.TransactionDto;

import java.time.LocalDate;
import java.util.List;

public interface TransactionService {
    TransactionDto createTransaction(TransactionDto transactionDto);
    List<TransactionDto> getTransactionListBetweenDates(Long id, LocalDate startDate, LocalDate endDate);
}
