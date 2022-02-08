package com.example.web4.exceptions;

import org.springframework.http.HttpStatus;

public class JwtAuthenticationException extends BaseException {

    private static final String ERROR_CODE = "AUTHENTICATION_ERROR";

    public JwtAuthenticationException(String message) {
        super(message, HttpStatus.UNAUTHORIZED, ERROR_CODE);
    }

}
