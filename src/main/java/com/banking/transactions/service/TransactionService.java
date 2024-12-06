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
    private AccountRepository accountRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public UserAccount createAccount(UserAccount account) {
        //UserAccount account = new UserAccount(firstName, lastName, initial_balance);
        account = accountRepository.createAccount(account);
        transactionRepository.createTransactionList(account.getId());
        return account;
    }

    //Invalidates usage of DTO? Perform operation in repository layer?
    public TransactionDTO transferFunds(TransactionDTO transaction) {
        accountRepository.updateBalance(transaction.getSrcAccount(), -transaction.getAmount());
        accountRepository.updateBalance(transaction.getDestAccount(), transaction.getAmount());
        return transactionRepository.addTransaction(transaction);
    }

    public TransactionList getAccountTransactions(long accountId) {
        return transactionRepository.getAccountTransactions(accountId);
    }
}
