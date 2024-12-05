package com.banking.transactions.repository;

import com.banking.transactions.repository.TransactionRepository;

import com.banking.transactions.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
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
        //Would've been more efficient to just use a(Id-1) but this better for if change Id naming system
        UserAccount account = findAccountById(account_id);
        account.setBalance(account.getBalance()+funds_moved);
        System.out.println(account.getId() + " " + account.getBalance()); // Test
    }

    private UserAccount findAccountById(long account_id){
        return accounts.stream().filter(a -> a.getId() == account_id).findFirst().get();
    }
}
