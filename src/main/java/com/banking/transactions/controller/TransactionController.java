package com.banking.transactions.controller;

import com.banking.transactions.model.UserAccount;
import com.banking.transactions.service.TransactionService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transaction_service;

    @PostMapping("/accounts")
    public UserAccount create_account(@RequestBody UserAccount user_account) {
        return transaction_service.createAccount(user_account);
    }
}
