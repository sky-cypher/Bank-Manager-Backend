package com.examplewe.bankmanager.service;

import com.examplewe.bankmanager.model.Account;
import com.examplewe.bankmanager.model.Transaction;
import com.examplewe.bankmanager.repo.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.examplewe.bankmanager.exception.TransactionNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionService {
    
    private final TransactionRepo transactionRepo;
    private final AccountService accountService;
    
    @Autowired
    public TransactionService(TransactionRepo transactionrepo,
                              AccountService accountService) {
        this.transactionRepo = transactionrepo;
        this.accountService = accountService;
    }

    @Transactional
    public Transaction deposit(Transaction transaction) {
        Account accountTo = accountService.getAccount(
                transaction.getAccountToID());
        accountTo.setBalance(
                accountTo.getBalance()
                + transaction.getAmount()
        );
        accountService.updateAccount(accountTo);
        return transactionRepo.save(transaction);
    }

    @Transactional
    public Transaction withdraw(Transaction transaction) {
        Account accountFrom = accountService.getAccount(
                transaction.getAccountFromID());
        accountFrom.setBalance(
                accountFrom.getBalance()
                - transaction.getAmount()
        );
        accountService.updateAccount(accountFrom);
        return transactionRepo.save(transaction);
    }

    @Transactional
    public Transaction transfer(Transaction transaction){
        Transaction transfer = this.withdraw(transaction);
        transfer = this.deposit(transfer);
        return transactionRepo.save(transfer);
    }

    public List<Transaction> getTransactions() {
        return transactionRepo.findAll();
    }

    public Transaction getTransaction(long id) {
        return transactionRepo.findById(id)
                .orElseThrow(() -> new TransactionNotFoundException(id));
    }


    public List<Transaction> getTransactionByAccountTo(long id) {
        return transactionRepo.findAllByAccountToID(id);
    }

    public List<Transaction> getTransactionByAccountFrom(long id) {
        return transactionRepo.findAllByAccountFromID(id);
    }
}
