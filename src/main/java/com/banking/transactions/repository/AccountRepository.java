package com.banking.transactions.repository;

import com.banking.transactions.model.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class AccountRepository {
    private List<UserAccount> accounts = new ArrayList<UserAccount>();

    public UserAccount createAccount(UserAccount account) {
        accounts.add(account);
        return account;
    }
}
