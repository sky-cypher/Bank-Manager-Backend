package com.examplewe.bank.exception;

public class TransactionNotFoundException extends RuntimeException {
    public TransactionNotFoundException(long id) {
        super("Transaction not found by id :" + id);
    }
}
