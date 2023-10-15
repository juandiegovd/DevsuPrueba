package com.devsu.cliente.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cliente.exception.ErrorMessages.CLI_01_MESSAGE;

@Getter
public class ClientNotFoundException extends RuntimeException implements NotFoundException{
    private final String code = "CLI_01";
    private final String message;
    private final transient Object data;

    @Override
    public String getCode() {
        return code;
    }

    @Value
    static class Data{
        Long clientId;
    }

    public ClientNotFoundException(Long clientId){
        super();
        this.message = String.format(CLI_01_MESSAGE, clientId);
        this.data = new Data(clientId);
    }
}
