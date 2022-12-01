package com.examplewe.bankmanager.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super("Customer not found by id :" + id);
    }
}
