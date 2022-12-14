package com.examplewe.bankmanager.service;

import com.examplewe.bankmanager.exception.AccountNotFoundException;
import com.examplewe.bankmanager.model.Account;
import com.examplewe.bankmanager.repo.AccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepo accountRepo;

    @Autowired
    public AccountService(AccountRepo accountRepo) {
        this.accountRepo = accountRepo;
    }

    public Account addAccount(Account account){
        return accountRepo.save(account);
    }

    public List<Account> getAccounts(){
        return accountRepo.findAll();
    }

    public Account getAccount(long accountID){
        return accountRepo.findById(accountID)
                .orElseThrow(() -> new AccountNotFoundException(accountID));
    }

    public void deleteAccount(long accountID) {
        accountRepo.deleteById(accountID);
    }

    public void deleteAccountsByCustomerID(long customerID) {
        accountRepo.deleteAllByCustomerID(customerID);
    }
    public Account updateAccount(Account account) {
        long id = account.getAccountID();
        if (accountRepo.existsById(id))
            return accountRepo.save(account);
        else
            throw new AccountNotFoundException(id);
    }

    public List<Account> getAccountsByCustomerID(long customerID) {
        return accountRepo.findAllByCustomerID(customerID);
    }
}
