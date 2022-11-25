package com.examplewe.bank.model;

import javax.persistence.*;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "account_id")
    @SequenceGenerator(name = "account_id")
    @Column(updatable = false, nullable = false)
    private long accountID;
    private long balance = 0;
    @Column(updatable = false,nullable = false)
    private long customerID;

    public Account() {
    }

    public Account(long accountID, long balance, long customerID) {
        this.accountID = accountID;
        this.balance = balance;
        this.customerID = customerID;
    }

    public Account(long balance, long customerID) {
        this.balance = balance;
        this.customerID = customerID;
    }

    public long getAccountID() {
        return accountID;
    }


    public long getBalance() {
        return balance;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    public long getCustomerID() {
        return customerID;
    }

    public void setCustomerID(long customerID) {
        this.customerID = customerID;
    }
}
