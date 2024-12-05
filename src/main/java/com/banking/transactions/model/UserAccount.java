package com.banking.transactions.model;

import lombok.*;

@Data
@Getter
@Setter
//@NoArgsConstructor
public class UserAccount {
    //private @Generated @Setter(AccessLevel.PROTECTED) long id;
    private long id;
    private String first_name;
    private String last_name;
    private double balance;

    public UserAccount(String first_name, String last_name, double balance) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.balance = balance;
        this.id = -1;
    }
}
