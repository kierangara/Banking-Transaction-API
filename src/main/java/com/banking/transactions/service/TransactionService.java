package com.banking.transactions.service;

import com.banking.transactions.repository.AccountRepository;
import com.banking.transactions.model.UserAccount;
import com.banking.transactions.model.TransactionDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository account_repository;

    public UserAccount createAccount(UserAccount account) {
        //UserAccount account = new UserAccount(first_name, last_name, initial_balance);
        return account_repository.createAccount(account);
    }

    public TransactionDTO transferFunds(TransactionDTO transaction) {
        account_repository.updateBalance(transaction.src_account(), transaction.amount());
        account_repository.updateBalance(transaction.dest_account(), -transaction.amount());
        return transaction;
    }
}
