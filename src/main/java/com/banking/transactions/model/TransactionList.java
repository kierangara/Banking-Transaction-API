package com.banking.transactions.model;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@Getter
public class TransactionList {
    private long accountId;
    private List<TransactionDTO> transactions;

    public TransactionList(long accountId){
        this.accountId = accountId;
        transactions = new ArrayList<TransactionDTO>();
    }

    public void addTransaction(TransactionDTO transaction){
        transactions.add(transaction);
    }
}
