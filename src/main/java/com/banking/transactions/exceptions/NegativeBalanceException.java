package com.banking.transactions.exceptions;

public class NegativeBalanceException extends RuntimeException{
    public NegativeBalanceException() {
        super("Accounts cannot be created with a negative balance.");
    }
}
