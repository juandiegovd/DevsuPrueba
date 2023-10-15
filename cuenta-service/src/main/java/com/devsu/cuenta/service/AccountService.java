package com.devsu.cuenta.service;

import com.devsu.cuenta.dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);
    AccountDto updateAccount(AccountDto accountDto);
    void deleteAccount(AccountDto accountDto);
}
