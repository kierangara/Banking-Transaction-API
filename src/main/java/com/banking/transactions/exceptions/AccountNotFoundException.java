package com.banking.transactions.exceptions;

import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(Long id) {
        super("Could not find account " + id);
    }
}
