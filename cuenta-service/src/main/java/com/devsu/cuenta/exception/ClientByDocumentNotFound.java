package com.devsu.cuenta.exception;

import lombok.Getter;
import lombok.Value;

import static com.devsu.cuenta.exception.ErrorMessages.CLI_01_MESSAGE;


@Getter
public class ClientByDocumentNotFound extends RuntimeException implements NotFoundException{
    private final String code = "CLI_01";
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
        this.message = String.format(CLI_01_MESSAGE, documentNumber);
        this.data = new Data(documentNumber);
    }
}
