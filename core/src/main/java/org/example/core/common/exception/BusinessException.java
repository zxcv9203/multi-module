package org.example.core.common.exception;


import org.example.core.common.response.ResponseCode;

public class BusinessException extends RuntimeException {
    private final String code;
    private final String message;

    public BusinessException(ResponseCode code) {
        super(code.getMessage());
        this.code = code.getCode();
        this.message = code.getMessage();
    }
}
