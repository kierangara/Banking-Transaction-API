package com.banking.transactions.controller;

import com.banking.transactions.model.AccountDTO;
import com.banking.transactions.model.TransactionDTO;
import com.banking.transactions.model.TransactionList;
import com.banking.transactions.model.UserAccount;

import com.banking.transactions.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class TransactionController {

    @Autowired
    private TransactionService transaction_service;

    //Create a new user account with an initial balance
    //Input parameters {firstName, lastName, balance}
    @PostMapping("/accounts")
    public UserAccount createAccount(@RequestBody AccountDTO userAccount) {
        return transaction_service.createAccount(userAccount);
    }

    //Retrieve the basic information for a given account
    //Path Variable: id
    @GetMapping("/accounts/{id}")
    public UserAccount getAccount(@PathVariable long id) {
        return transaction_service.getAccount(id);
    }

    //Transfer funds from one account to another
    //Input parameters {srcAccount, destAccount, amount}
    @PostMapping("/transactions")
    public TransactionDTO transferFunds(@RequestBody TransactionDTO transaction) {
        return transaction_service.transferFunds(transaction);
    }

    //Retrieve the transaction history for a given account
    //Path Variable: id
    @GetMapping("/accounts/{id}/transactions")
    public TransactionList getAccountTransactions(@PathVariable long id) {
        return transaction_service.getAccountTransactions(id);
    }

}
