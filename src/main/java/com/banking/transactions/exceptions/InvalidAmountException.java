package com.banking.transactions.exceptions;

public class InvalidAmountException extends RuntimeException {
    public InvalidAmountException(double amount) {
        super("Invalid amount " + amount +". All transactions must have an amount greater than 0");
    }
}
