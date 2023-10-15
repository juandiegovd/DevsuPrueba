package com.devsu.cuenta.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cuenta.exception.ErrorMessages.ACC_01_MESSAGE;


@Getter
public class AccountExistsException extends RuntimeException implements InitialDataException{
    private final String code = "ACC_01";
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

    public AccountExistsException(String account){
        super();
        this.message = String.format(ACC_01_MESSAGE, account);
        this.data = new Data(account);
    }
}
