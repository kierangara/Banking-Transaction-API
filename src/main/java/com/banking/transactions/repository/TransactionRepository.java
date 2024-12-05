package com.banking.transactions.repository;

import com.banking.transactions.model.TransactionDTO;
import com.banking.transactions.model.TransactionList;
import com.banking.transactions.model.UserAccount;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransactionRepository {
    private List<TransactionList> transaction_lists = new ArrayList<TransactionList>();

    public TransactionList createTransactionList(long accountId){
        transaction_lists.add(new TransactionList(accountId));
        return findTransactionListById(accountId);
    }

    public TransactionDTO addTransaction(TransactionDTO transaction){
        TransactionList src_transaction_list = findTransactionListById(transaction.src_account());
        src_transaction_list.addTransaction(transaction);
        TransactionList dest_transaction_list = findTransactionListById(transaction.dest_account());
        dest_transaction_list.addTransaction(transaction);
        return transaction;
    }

    public TransactionList getAccountTransactions(long accountId){
        return findTransactionListById(accountId);
    }

    private TransactionList findTransactionListById(long account_id){
        return transaction_lists.stream().filter(a -> a.getAccountId() == account_id).findFirst().get();
    }
}