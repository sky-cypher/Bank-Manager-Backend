package com.examplewe.bank.resource;

import com.examplewe.bank.exception.CustomerNotFoundException;
import com.examplewe.bank.model.Account;
import com.examplewe.bank.model.Customer;
import com.examplewe.bank.model.Transaction;
import com.examplewe.bank.service.AccountService;
import com.examplewe.bank.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountResource {
    
    private final AccountService accountService;
    private final CustomerService customerService;
    
    public AccountResource(
            AccountService accountService,
            CustomerService customerService) {
        this.accountService = accountService;
        this.customerService = customerService;
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Account> getAccount(@PathVariable("id") long id) {
        Account account = accountService.getAccount(id);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Account>> getAccounts() {
        List<Account> accounts = accountService.getAccounts();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/find/by/customer{id}")
    public ResponseEntity<List<Account>>
    getAccountByCustomer(@PathVariable("id") long id) {
        List<Account> accounts = accountService.getAccountsByCustomerID(id);
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Account>
    addAccount(@RequestBody Account account) {
        Customer customer = customerService.getCustomer(
                account.getCustomerID());
        if (customer == null)
            throw new CustomerNotFoundException(account.getCustomerID());
        Account newAccount = accountService.addAccount(account);
        return new ResponseEntity<>(newAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Account>
    updateAccount(@RequestBody Account account) {
        Account updateAccount = accountService.updateAccount(account);
        return new ResponseEntity<>(updateAccount, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteAccount(@PathVariable("id") long id) {
        accountService.deleteAccount(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
