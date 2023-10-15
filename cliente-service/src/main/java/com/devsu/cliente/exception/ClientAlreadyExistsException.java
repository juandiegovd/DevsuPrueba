package com.devsu.cliente.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cliente.exception.ErrorMessages.CLI_01_MESSAGE;
import static com.devsu.cliente.exception.ErrorMessages.CLI_03_MESSAGE;

@Getter
public class ClientAlreadyExistsException extends RuntimeException implements NotFoundException{
    private final String code = "CLI_03";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        String documentNumber;
    }

    public ClientAlreadyExistsException(String documentNumber){
        super();
        this.message = String.format(CLI_03_MESSAGE, documentNumber);
        this.data = new Data(documentNumber);
    }
}
