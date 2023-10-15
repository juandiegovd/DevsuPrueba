package com.devsu.cuenta.service;

import com.devsu.cuenta.client.ClientEsbClient;
import com.devsu.cuenta.dto.AccountDto;
import com.devsu.cuenta.entity.AccountEntity;
import com.devsu.cuenta.exception.AccountExistsException;
import com.devsu.cuenta.exception.AccountNotFoundException;
import com.devsu.cuenta.exception.ClientByDocumentNotFound;
import com.devsu.cuenta.mapper.AccountMapper;
import com.devsu.cuenta.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;
    private final ClientEsbClient clientEsbClient;

    @Override
    public AccountDto createAccount(AccountDto accountDto) {
        var client = clientEsbClient.getClient(accountDto.getClientDocument());
        if (client == null) throw new ClientByDocumentNotFound(accountDto.getClientDocument());

        var accountExists = accountRepository.findByNumberEquals(accountDto.getNumber());
        if (accountExists.isPresent()) throw new AccountExistsException(accountDto.getNumber());
        accountDto.setClientId(client.getId());
        var account = accountRepository.save(AccountMapper.MAPPER.toAccountEntity(accountDto));
        return AccountMapper.MAPPER.toAccountDto(account);
    }

    @Override
    public AccountDto updateAccount(AccountDto accountDto) {
        var account = accountRepository.findByNumberEquals(accountDto.getNumber());
        if (account.isEmpty()) throw new AccountNotFoundException(accountDto.getNumber());
        var clientUpdated = accountRepository.save(updateAccountDto(account.get(), accountDto));
        return AccountMapper.MAPPER.toAccountDto(clientUpdated);
    }

    private AccountEntity updateAccountDto(AccountEntity accountEntity, AccountDto accountDto) {
        accountEntity.setStatus(accountDto.getStatus());
        accountEntity.setType(accountDto.getType());
        return accountEntity;
    }

    @Override
    public void deleteAccount(AccountDto accountDto) {
        var account = accountRepository.findByNumberEquals(accountDto.getNumber());
        if (account.isEmpty()) throw new AccountNotFoundException(accountDto.getNumber());
        accountRepository.deleteAccountLogically(account.get().getNumber());
    }
}
