package com.banking.transactions.repository;

import com.banking.transactions.repository.TransactionRepository;

import com.banking.transactions.model.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountRepository {
    private List<UserAccount> accounts = new ArrayList<UserAccount>();

    public UserAccount createAccount(UserAccount account) {
        if (account.getBalance()<0){
            throw new NegativeBalanceException();
        }
        account.setId(accounts.size() + 1);
        accounts.add(account);
        System.out.println(account.getBalance()); //Test
        return account; //check
    }

    public void updateBalance(long accountId, double funds_moved){
        //Would've been more efficient to just use a(Id-1) but this better for if change Id naming system
        UserAccount account = findAccountById(accountId);
        double newBalance = account.getBalance() + funds_moved;
        if (newBalance >= 0){
            account.setBalance(newBalance);
        }
        else{
            throw new InsufficientFundsException(accountId);
        }
        System.out.println(account.getId() + " " + account.getBalance()); // Test
    }

    private UserAccount findAccountById(long accountId){
            return accounts.stream().filter(a -> a.getId() == accountId).findFirst()
                    .orElseThrow(()-> new AccountNotFoundException(accountId));
                    //.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find account " + accountId));
    }
}
