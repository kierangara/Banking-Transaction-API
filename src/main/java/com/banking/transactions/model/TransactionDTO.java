package com.banking.transactions.model;

public record TransactionDTO(long src_account, long dest_account, double amount) {
}
