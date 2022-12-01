package com.examplewe.bankmanager.resource;

import com.examplewe.bankmanager.model.Transaction;
import com.examplewe.bankmanager.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("transaction")
public class TransactionResource {

    private final TransactionService transactionService;

    @Autowired
    public TransactionResource(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<Transaction>
    transfer(@RequestBody Transaction transaction) {
        Transaction transfer = transactionService.transfer(transaction);
        return new ResponseEntity<>(transfer, HttpStatus.CREATED);
    }

    @PostMapping("/deposit")
    public ResponseEntity<Transaction>
    deposit(@RequestBody Transaction transaction) {
        Transaction deposit = transactionService.deposit(transaction);
        return new ResponseEntity<>(deposit, HttpStatus.CREATED);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<Transaction>
    withdraw(@RequestBody Transaction transaction) {
        Transaction withdraw = transactionService.withdraw(transaction);
        return new ResponseEntity<>(withdraw, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Transaction>> getTransactions() {
        List<Transaction> transactions = transactionService.getTransactions();
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Transaction>
    getTransaction(@PathVariable("id")long id){
        Transaction transaction = transactionService.getTransaction(id);
        return new ResponseEntity<>(transaction,HttpStatus.OK);
    }

    @GetMapping("/find/by/account/to/{id}")
    public ResponseEntity<List<Transaction>>
    getTransactionByAccountTo(@PathVariable("id")long id){
        List<Transaction> transactions =
                transactionService.getTransactionByAccountTo(id);
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }

    @GetMapping("/find/by/account/from/{id}")
    public ResponseEntity<List<Transaction>>
    getTransactionByAccountFrom(@PathVariable("id")long id){
        List<Transaction> transactions =
                transactionService.getTransactionByAccountFrom(id);
        return new ResponseEntity<>(transactions,HttpStatus.OK);
    }
}
