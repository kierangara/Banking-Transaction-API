package com.banking.transactions.repository;

import org.springframework.http.HttpStatus;

public class NegativeBalanceException extends RuntimeException{
    NegativeBalanceException() {
        super("Accounts cannot be created with a negative balance.");
    }

    public HttpStatus getStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
