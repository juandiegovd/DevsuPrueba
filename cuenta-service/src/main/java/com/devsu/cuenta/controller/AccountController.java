package com.devsu.cuenta.controller;

import com.devsu.cuenta.dto.AccountDto;
import com.devsu.cuenta.facade.AccountFacade;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/cuentas")
public class AccountController {
    private final AccountFacade accountFacade;

    public AccountController(AccountFacade accountFacade){
        this.accountFacade = accountFacade;
    }

    @PostMapping("")
    public AccountDto createAccount(@RequestBody AccountDto accountDto){
        return accountFacade.createAccount(accountDto);
    }

    @PutMapping("")
    public AccountDto updateAccount(@RequestBody AccountDto accountDto){
        return accountFacade.updateAccount(accountDto);
    }

    @DeleteMapping("")
    public void deleteAccount(@RequestBody AccountDto accountDto){
        accountFacade.deleteAccount(accountDto);
    }

}
