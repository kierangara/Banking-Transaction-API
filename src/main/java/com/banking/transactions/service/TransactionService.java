package com.banking.transactions.service;

import com.banking.transactions.model.AccountDTO;
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

    public UserAccount createAccount(AccountDTO accountDTO) {
        InputValidation.ValidateAccountInput(accountDTO);
        UserAccount account = accountRepository.createAccount(accountDTO);
        transactionRepository.createTransactionList(account.getId());
        return account;
    }

    public UserAccount getAccount(long accountId) {
        return accountRepository.getAccount(accountId);
    }

    public TransactionDTO transferFunds(TransactionDTO transaction){
        InputValidation.ValidateTransactionInput(transaction);
        accountRepository.updateBalance(transaction.getSrcAccount(), -transaction.getAmount());
        accountRepository.updateBalance(transaction.getDestAccount(), transaction.getAmount());
        return transactionRepository.addTransaction(transaction);
    }

    public TransactionList getAccountTransactions(long accountId) {
        return transactionRepository.getAccountTransactions(accountId);
    }
}
