package com.banking.transactions.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AccountDTO {
    private String firstName;
    private String lastName;
    private double balance;
}
