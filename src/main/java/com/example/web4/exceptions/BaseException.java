package com.example.web4.exceptions;

import org.springframework.http.HttpStatus;

public class BaseException extends Exception{

    private final HttpStatus httpStatus;
    private final String errorCode;

    public BaseException(String message, HttpStatus httpStatus, String errorCode) {
        super(message);
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
