package com.example.web4.exceptions;

import org.springframework.http.HttpStatus;

public class WrongPasswordException extends BaseException{

    private static final String ERROR_CODE = "WRONG_PASSWORD_ERROR";

    public WrongPasswordException(String message) {
        super(message, HttpStatus.BAD_REQUEST, ERROR_CODE);
    }
}
