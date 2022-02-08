package com.example.web4.exceptions;

import org.springframework.http.HttpStatus;

public class UserAlreadyExistException extends BaseException{

    private static final String ERROR_CODE = "USER_ALREADY_EXIST_ERROR";

    public UserAlreadyExistException(String message) {
        super(message, HttpStatus.BAD_REQUEST, ERROR_CODE);
    }

}
