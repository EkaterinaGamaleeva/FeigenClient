package com.citizens.controller;

import com.citizens.response.CitizenErrorResponse;
import com.citizens.response.CitizenNotFoundExcention;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class DefaultAdvice {

    @ExceptionHandler
    private ResponseEntity<CitizenErrorResponse> handlerException(CitizenNotFoundExcention e) {
        CitizenErrorResponse response = new CitizenErrorResponse("Нет людей в этом городе", System.currentTimeMillis());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
