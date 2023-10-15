package com.devsu.cliente.exception;

public interface BusinessException {
    String getMessage();
    String getCode();
    Object getData();
}
