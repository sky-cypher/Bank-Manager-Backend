package com.examplewe.bank.exception;

import java.util.function.Supplier;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(long id) {
        super("Customer not found by id :" + id);
    }
}
