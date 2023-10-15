package com.devsu.cuenta.exception;

public interface BusinessException {
    String getMessage();
    String getCode();
    Object getData();
}
