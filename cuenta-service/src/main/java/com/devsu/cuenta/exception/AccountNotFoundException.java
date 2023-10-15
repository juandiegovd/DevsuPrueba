package com.devsu.cuenta.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cuenta.exception.ErrorMessages.ACC_02_MESSAGE;


@Getter
public class AccountNotFoundException extends RuntimeException implements InitialDataException{
    private final String code = "ACC_02";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String account;
    }

    public AccountNotFoundException(String account){
        super();
        this.message = String.format(ACC_02_MESSAGE, account);
        this.data = new Data(account);
    }
}
