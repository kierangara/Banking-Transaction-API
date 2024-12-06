package com.banking.transactions.model;

import lombok.*;

@Data
@Getter
@Setter
//@NoArgsConstructor
public class UserAccount {
    //private @Generated @Setter(AccessLevel.PROTECTED) long id;
    private long id;
    private String firstName;
    private String lastName;
    private double balance;

    public UserAccount(String firstName, String lastName, double balance) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
    }
}
