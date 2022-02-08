package com.example.web4.exceptions;

import org.springframework.http.HttpStatus;

public class UserNotFoundException extends BaseException{

    private static final String ERROR_CODE = "USER_NOT_FOUND_ERROR";

    public UserNotFoundException(String message) {
        super(message, HttpStatus.BAD_REQUEST, ERROR_CODE);
    }
}
