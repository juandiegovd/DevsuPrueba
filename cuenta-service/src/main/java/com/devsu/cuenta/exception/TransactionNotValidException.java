package com.devsu.cuenta.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cuenta.exception.ErrorMessages.TRA_01_MESSAGE;


@Getter
public class TransactionNotValidException extends RuntimeException implements InitialDataException{
    private final String code = "TRA_01";
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

    public TransactionNotValidException(String account){
        super();
        this.message = TRA_01_MESSAGE;
        this.data = new Data(account);
    }
}
