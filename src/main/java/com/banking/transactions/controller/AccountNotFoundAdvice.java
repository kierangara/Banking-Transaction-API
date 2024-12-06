package com.banking.transactions.controller;

import com.banking.transactions.model.ErrorDTO;
import com.banking.transactions.repository.AccountNotFoundException;
import com.banking.transactions.repository.InsufficientFundsException;
import com.banking.transactions.repository.NegativeBalanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AccountNotFoundAdvice {
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    //Ensures proper serialization of JSON to avoid conversion error
    public ResponseEntity<ErrorDTO> accountNotFoundHandler(AccountNotFoundException e) {
        ErrorDTO errorResponse = new ErrorDTO(e.getMessage(), e.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(InsufficientFundsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //Ensures proper serialization of JSON to avoid conversion error
    public ResponseEntity<ErrorDTO> insufficientFundsHandler(InsufficientFundsException e) {
        ErrorDTO errorResponse = new ErrorDTO(e.getMessage(), e.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NegativeBalanceException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    //Ensures proper serialization of JSON to avoid conversion error
    public ResponseEntity<ErrorDTO> negativeBalanceHandler(NegativeBalanceException e) {
        ErrorDTO errorResponse = new ErrorDTO(e.getMessage(), e.getStatus());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
