package com.banking.transactions.service;

import com.banking.transactions.exceptions.InvalidAmountException;
import com.banking.transactions.exceptions.MissingInformationException;
import com.banking.transactions.exceptions.NullTransactionException;
import com.banking.transactions.model.TransactionDTO;
import com.banking.transactions.model.UserAccount;
import com.banking.transactions.exceptions.NegativeBalanceException;
import lombok.SneakyThrows;

public class InputValidation {
    public static void ValidateTransactionInput(TransactionDTO transaction) {
        long srcAccount = transaction.getSrcAccount();
        if(srcAccount<1){
            throw new MissingInformationException("Source account");
        }
        long destAccount = transaction.getDestAccount();
        if(destAccount<1){
            throw new MissingInformationException("Destination account");
        }
        if(srcAccount==destAccount){
            throw new NullTransactionException();
        }
        if(transaction.getAmount()<1){
            throw new InvalidAmountException(transaction.getAmount());
        }
    }

    public static void ValidateAccountInput(UserAccount account){
        if (account.getBalance()<0){
            throw new NegativeBalanceException();
        }
    }
}
