package com.devsu.cuenta.service;

import com.devsu.cuenta.AbstractBaseJUnit5Test;
import com.devsu.cuenta.client.ClientEsbClient;
import com.devsu.cuenta.dto.AccountDto;
import com.devsu.cuenta.dto.ClientWebResponseDto;
import com.devsu.cuenta.entity.AccountEntity;
import com.devsu.cuenta.repository.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

class AccountServiceTest extends AbstractBaseJUnit5Test {
    private final AccountRepository accountRepository = Mockito.mock(AccountRepository.class);
    private final ClientEsbClient clientEsbClient = Mockito.mock(ClientEsbClient.class);
    private final AccountServiceImpl accountService = new AccountServiceImpl(accountRepository, clientEsbClient);

    @Test
    public void createAccount() throws Exception{
        var accountEntity = convertTo("/AccountEntity.json", AccountEntity.class);
        var accountDto = convertTo("/AccountDto.json", AccountDto.class);
        when(clientEsbClient.getClient(anyString())).thenReturn(convertTo("/ClientWebResponseDto.json", ClientWebResponseDto.class));
        when(accountRepository.findByNumberEquals(anyString())).thenReturn(Optional.empty());
        when(accountRepository.save(any(AccountEntity.class))).thenReturn(accountEntity);

        var accountResponse = accountService.createAccount(accountDto);
        Assertions.assertEquals(accountResponse.getId(),accountEntity.getId());
    }
}
