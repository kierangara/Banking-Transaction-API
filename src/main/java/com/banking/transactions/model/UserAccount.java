package com.banking.transactions.model;

import lombok.*;

import java.util.Objects;

@Data
@Getter
@Setter
public class UserAccount {
    private long id;
    private String firstName;
    private String lastName;
    private double balance;

    public UserAccount(String firstName, String lastName, double balance) {
        this.id = -1;
        this.firstName = Objects.toString(firstName, "");
        this.lastName = Objects.toString(lastName, "");
        this.balance = balance;
    }
}
