package com.banking.transactions.repository;

import com.banking.transactions.exceptions.AccountNotFoundException;

import com.banking.transactions.exceptions.InsufficientFundsException;
import com.banking.transactions.model.AccountDTO;
import com.banking.transactions.model.UserAccount;
import org.springframework.stereotype.Repository;


import java.util.ArrayList;
import java.util.List;


@Repository
public class AccountRepository {
    private final List<UserAccount> accounts = new ArrayList<>();

    public UserAccount createAccount(AccountDTO accountDTO) {
        UserAccount account = new UserAccount(accountDTO.getFirstName(),accountDTO.getLastName(),accountDTO.getBalance());
        account.setId(accounts.size() + 1);
        accounts.add(account);
        return account;
    }

    public UserAccount getAccount(long id) {
        return findAccountById(id);
    }

    public void updateBalance(long accountId, double funds_moved){
        UserAccount account = findAccountById(accountId);
        double newBalance = account.getBalance() + funds_moved;
        if (newBalance >= 0){
            account.setBalance(newBalance);
        }
        else{
            throw new InsufficientFundsException(accountId);
        }
    }

    private UserAccount findAccountById(long accountId){
            return accounts.stream().filter(a -> a.getId() == accountId).findFirst()
                    .orElseThrow(()-> new AccountNotFoundException(accountId));
    }
}
