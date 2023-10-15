package com.devsu.cuenta.service;

import com.devsu.cuenta.dto.TransactionDto;
import com.devsu.cuenta.entity.AccountEntity;
import com.devsu.cuenta.entity.TransactionEntity;
import com.devsu.cuenta.exception.AccountNotFoundException;
import com.devsu.cuenta.exception.TransactionNotValidException;
import com.devsu.cuenta.mapper.TransactionMapper;
import com.devsu.cuenta.repository.AccountRepository;
import com.devsu.cuenta.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.*;
import java.util.List;


@RequiredArgsConstructor
@Service
public class TransactionServiceImpl implements TransactionService{

    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionDto createTransaction(TransactionDto transactionDto) {
        if (transactionDto.getAmount() == 0){
            throw new TransactionNotValidException(transactionDto.getAccountNumber());
        }
        var account = accountRepository.findByNumberEquals(transactionDto.getAccountNumber());
        if (account.isEmpty()) throw new AccountNotFoundException(transactionDto.getAccountNumber());
        var actualTransaction = TransactionMapper.MAPPER.toTransactionEntity(transactionDto);
        updateFinalAmount(transactionDto, account.get(), actualTransaction);
        account.get().setActualAmount(transactionDto.getFinalAmount());
        actualTransaction.setAccountEntity(account.get());
        actualTransaction.setCreatedOn(LocalDateTime.now());
        return TransactionMapper.MAPPER.toTransactionDto(transactionRepository.save(actualTransaction));
    }

    @Override
    public List<TransactionDto> getTransactionListBetweenDates(Long id, LocalDate startDate, LocalDate endDate) {
        var transactionList = transactionRepository.getTransactionsBetweenDates(id, LocalDateTime.of(startDate, LocalTime.of(0,0)), LocalDateTime.of(endDate, LocalTime.of(23,59)));
        return TransactionMapper.MAPPER.toTransactionDtoList(transactionList);
    }

    private void updateFinalAmount(TransactionDto transactionDto, AccountEntity account, TransactionEntity actualTransaction) {
        var lastTransaction = transactionRepository.
                findFirstByAccountEntity_NumberOrderByCreatedOnDesc(transactionDto.getAccountNumber());
        if (lastTransaction.isEmpty()){
            actualTransaction.setFinalAmount(account.getFirstAmount()+ actualTransaction.getMovement());
        }else{
            actualTransaction.setFinalAmount(lastTransaction.get().getFinalAmount()+ actualTransaction.getMovement());
        }

        if (actualTransaction.getFinalAmount() < 0) actualTransaction.setFinalAmount(0.0);
    }
}
