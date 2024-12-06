package com.banking.transactions.repository;

import org.springframework.http.HttpStatus;

public class AccountNotFoundException extends RuntimeException {
    AccountNotFoundException(Long id) {
        super("Could not find account " + id);
    }

    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
