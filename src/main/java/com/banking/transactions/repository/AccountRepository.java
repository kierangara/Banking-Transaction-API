package com.banking.transactions.repository;

import com.banking.transactions.model.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class AccountRepository {
    private List<UserAccount> accounts = new ArrayList<UserAccount>();

    public UserAccount createAccount(UserAccount account) {
        account.setId(accounts.size() + 1);
        accounts.add(account);
        System.out.println(account.getBalance()); //Test
        return account; //check
    }

    public void updateBalance(long account_id, double funds_moved){
        UserAccount account = accounts.stream().filter(a -> a.getId() == account_id).findFirst().get();
        account.setBalance(account.getBalance()+funds_moved);
        System.out.println(account.getId() + " " + account.getBalance()); // Test
    }
}
