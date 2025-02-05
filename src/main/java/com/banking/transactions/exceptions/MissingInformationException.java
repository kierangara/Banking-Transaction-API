package com.banking.transactions.exceptions;

public class MissingInformationException extends RuntimeException {
    public MissingInformationException(String missingField) {
        super(missingField + " is a required field and must be greater than 0.");
    }
}
