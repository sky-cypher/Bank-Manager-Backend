package com.examplewe.bankmanager.exception;

public class AccountNotFoundException extends RuntimeException{
    public AccountNotFoundException(long id) {
        super("Account not found by id :" + id);
    }
}
