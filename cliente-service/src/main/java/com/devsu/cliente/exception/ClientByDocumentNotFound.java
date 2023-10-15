package com.devsu.cliente.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cliente.exception.ErrorMessages.CLI_02_MESSAGE;

@Getter
public class ClientByDocumentNotFound extends RuntimeException implements InitialDataException{
    private final String code = "CLI_02";
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

    public ClientByDocumentNotFound(String documentNumber){
        super();
        this.message = String.format(CLI_02_MESSAGE, documentNumber);
        this.data = new Data(documentNumber);
    }
}
