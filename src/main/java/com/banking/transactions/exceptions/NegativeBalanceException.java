package com.banking.transactions.exceptions;

import org.springframework.http.HttpStatus;

public class NegativeBalanceException extends RuntimeException{
    public NegativeBalanceException() {
        super("Accounts cannot be created with a negative balance.");
    }
}
