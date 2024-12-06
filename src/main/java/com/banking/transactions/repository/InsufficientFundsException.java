package com.banking.transactions.repository;

import org.springframework.http.HttpStatus;

public class InsufficientFundsException extends RuntimeException{
    InsufficientFundsException(Long id) {
        super("The account with id " + id + " does not have sufficient funds to complete this transaction");
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
