package com.banking.transactions.exceptions;

public class InsufficientFundsException extends RuntimeException{
    public InsufficientFundsException(Long id) {
        super("The account with id " + id + " does not have sufficient funds to complete this transaction");
    }
}
