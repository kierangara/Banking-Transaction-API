package com.banking.transactions.exceptions;

public class NullTransactionException extends RuntimeException {
    public NullTransactionException() {
        super("The source and destination accounts of a transaction must not be the same.");
    }
}
