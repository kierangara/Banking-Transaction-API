package com.banking.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;


@AllArgsConstructor
@RequiredArgsConstructor
@Getter
public class TransactionDTO {
    private long srcAccount;
    private long destAccount;
    private double amount;
}
