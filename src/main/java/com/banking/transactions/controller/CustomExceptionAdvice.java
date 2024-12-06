package com.banking.transactions.controller;

import com.banking.transactions.exceptions.*;
import com.banking.transactions.model.ErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomExceptionAdvice {
    @ExceptionHandler({AccountNotFoundException.class,
            InsufficientFundsException.class,
    NegativeBalanceException.class,
    MissingInformationException.class,
    InvalidAmountException.class,
    NullTransactionException.class,})
    //Ensures proper serialization of JSON to avoid conversion error
    public ResponseEntity<ErrorDTO> customExceptionHandler(Exception e) {
        ErrorDTO errorResponse = new ErrorDTO(e.getMessage(), getHttpStatus(e));
        return new ResponseEntity<>(errorResponse, getHttpStatus(e));
    }

    private HttpStatus getHttpStatus(Exception e) {
        if (e instanceof AccountNotFoundException) {
            return HttpStatus.NOT_FOUND;  // For AccountNotFoundException
        } else {
            return HttpStatus.BAD_REQUEST;  // For all illegal request exceptions e.g. Insufficient funds, negative balance
        }
    }
}
