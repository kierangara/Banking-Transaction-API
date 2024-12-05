package com.banking.transactions.service;

import com.banking.transactions.model.TransactionList;
import com.banking.transactions.repository.AccountRepository;
import com.banking.transactions.model.UserAccount;
import com.banking.transactions.model.TransactionDTO;

import com.banking.transactions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    private AccountRepository account_repository;
    @Autowired
    private TransactionRepository transaction_repository;

    public UserAccount createAccount(UserAccount account) {
        //UserAccount account = new UserAccount(first_name, last_name, initial_balance);
        account = account_repository.createAccount(account);
        transaction_repository.createTransactionList(account.getId());
        return account;
    }

    //Invalidates usage of DTO? Perform operation in repository layer?
    public TransactionDTO transferFunds(TransactionDTO transaction) {
        account_repository.updateBalance(transaction.src_account(), -transaction.amount());
        account_repository.updateBalance(transaction.dest_account(), transaction.amount());
        return transaction_repository.addTransaction(transaction);
    }

    public TransactionList getAccountTransactions(long account_id) {
        return transaction_repository.getAccountTransactions(account_id);
    }
}
