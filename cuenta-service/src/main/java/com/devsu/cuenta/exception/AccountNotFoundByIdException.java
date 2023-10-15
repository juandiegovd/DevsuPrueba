package com.devsu.cuenta.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cuenta.exception.ErrorMessages.ACC_03_MESSAGE;


@Getter
public class AccountNotFoundByIdException extends RuntimeException implements InitialDataException{
    private final String code = "ACC_03";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        int id;
    }

    public AccountNotFoundByIdException(int id){
        super();
        this.message = String.format(ACC_03_MESSAGE, id);
        this.data = new Data(id);
    }
}
