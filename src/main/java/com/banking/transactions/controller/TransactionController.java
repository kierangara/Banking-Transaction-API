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

    @PostMapping("/accounts")
    public UserAccount createAccount(@RequestBody AccountDTO user_account) {
        return transaction_service.createAccount(user_account);
    }

    @GetMapping("/accounts/{id}")
    public UserAccount getAccount(@PathVariable long id) {
        return transaction_service.getAccount(id);
    }

    @PostMapping("/transactions")
    public TransactionDTO transferFunds(@RequestBody TransactionDTO transaction) {
        return transaction_service.transferFunds(transaction);
    }

    @GetMapping("/accounts/{id}/transactions")
    public TransactionList getAccountTransactions(@PathVariable long id) {
        return transaction_service.getAccountTransactions(id);
    }

}
