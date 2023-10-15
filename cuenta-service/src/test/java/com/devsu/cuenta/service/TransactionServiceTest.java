package com.devsu.cuenta.service;

import com.devsu.cuenta.AbstractBaseJUnit5Test;
import com.devsu.cuenta.dto.TransactionDto;
import com.devsu.cuenta.entity.AccountEntity;
import com.devsu.cuenta.entity.TransactionEntity;
import com.devsu.cuenta.exception.TransactionNotValidException;
import com.devsu.cuenta.repository.AccountRepository;
import com.devsu.cuenta.repository.TransactionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionServiceTest extends AbstractBaseJUnit5Test {
    private final TransactionRepository transactionRepository = Mockito.mock(TransactionRepository.class);
    private final AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private final TransactionServiceImpl transactionService = new TransactionServiceImpl(accountRepository, transactionRepository);

    @Test
    public void createTransaction() throws Exception {
        TransactionDto transactionDto = convertTo("/TransactionDto.json", TransactionDto.class);
        when(accountRepository.findByNumberEquals(transactionDto.getAccountNumber())).thenReturn(Optional.of(convertTo("/AccountEntity.json", AccountEntity.class)));
        when(transactionRepository.save(any(TransactionEntity.class))).thenReturn(convertTo("/TransactionEntity.json", TransactionEntity.class));
        var transactionResp = transactionService.createTransaction(transactionDto);
        Assertions.assertEquals(transactionDto.getAmount(),transactionResp.getAmount());
    }

    @Test
    public void createTransactionError() throws Exception {
        TransactionDto transactionDto = convertTo("/TransactionDto.json", TransactionDto.class);
        transactionDto.setAmount(0.0);
        var exception = Assertions.assertThrows(TransactionNotValidException.class, () -> transactionService.createTransaction(transactionDto));
        Assertions.assertEquals("TRA_01", exception.getCode());
    }
}
