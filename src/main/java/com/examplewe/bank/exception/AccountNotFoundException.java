package com.examplewe.bank.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(long id) {
        super("Account not found by id :" + id);
    }
}
