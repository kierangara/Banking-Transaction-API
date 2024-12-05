package com.banking.transactions.controller;

import com.banking.transactions.model.TransactionDTO;
import com.banking.transactions.model.UserAccount;
import com.banking.transactions.service.TransactionService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.pulsar.PulsarProperties;
import org.springframework.web.bind.annotation.*;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transaction_service;

    @PostMapping("/accounts")
    public UserAccount createAccount(@RequestBody UserAccount user_account) {
        return transaction_service.createAccount(user_account);
    }

    @PutMapping("/transactions")
    public TransactionDTO transferFunds(@RequestBody TransactionDTO transaction) {
        return transaction_service.transferFunds(transaction);
    }
}
