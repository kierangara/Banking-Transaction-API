package com.banking.transactions.exceptions;

import org.springframework.http.HttpStatus;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(Long id) {
        super("The account with id " + id + " does not have sufficient funds to complete this transaction");
    }
}
