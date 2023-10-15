package com.devsu.cuenta.facade;

import com.devsu.cuenta.dto.AccountDto;
import com.devsu.cuenta.service.AccountService;
import org.springframework.stereotype.Component;

@Component
public class AccountFacade {
    private final AccountService accountService;
    public AccountFacade(AccountService accountService){
        this.accountService = accountService;
    }

    public AccountDto createAccount(AccountDto accountDto){
        return accountService.createAccount(accountDto);
    }

    public AccountDto updateAccount(AccountDto accountDto){
        return accountService.updateAccount(accountDto);
    }

    public void deleteAccount(AccountDto accountDto){
        accountService.deleteAccount(accountDto);
    }

}
