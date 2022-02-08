package com.example.web4.exceptions;

import com.example.web4.dto.DefaultResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class DefaultAdvice {
    @ExceptionHandler(UserAlreadyExistException.class)
    public ResponseEntity<DefaultResponse> handleException(UserAlreadyExistException e) {
        DefaultResponse defaultResponse = new DefaultResponse(e.getMessage());
        return new ResponseEntity<>(defaultResponse, e.getHttpStatus());
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<DefaultResponse> handleException(UserNotFoundException e) {
        DefaultResponse defaultResponse = new DefaultResponse(e.getMessage());
        return new ResponseEntity<>(defaultResponse, e.getHttpStatus());
    }

    @ExceptionHandler(WrongPasswordException.class)
    public ResponseEntity<DefaultResponse> handleException(WrongPasswordException e) {
        DefaultResponse defaultResponse = new DefaultResponse(e.getMessage());
        return new ResponseEntity<>(defaultResponse, e.getHttpStatus());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<DefaultResponse> handleException(MethodArgumentNotValidException e) {
        DefaultResponse defaultResponse = new DefaultResponse(e.getMessage());
        return new ResponseEntity<>(defaultResponse, HttpStatus.BAD_REQUEST);
    }
}
