package com.examplewe.bank.model;

import javax.persistence.*;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "transaction_id")
    @SequenceGenerator(name = "transaction_id")
    @Column(nullable = false, updatable = false)
    private long transactionID;
    private long accountFromID;
    private long accountToID;
    @Column(nullable = false, updatable = false)
    private long amount;

    public Transaction() {
    }

    public Transaction(long accountFromID,
                       long accountToID,
                       long amount) {
        this.accountFromID = accountFromID;
        this.accountToID = accountToID;
        this.amount = amount;
    }

    public long getTransactionID() {
        return transactionID;
    }

    public long getAccountFromID() {
        return accountFromID;
    }

    public void setAccountFromID(long accountFromID) {
        this.accountFromID = accountFromID;
    }

    public long getAccountToID() {
        return accountToID;
    }

    public void setAccountToID(long accountToID) {
        this.accountToID = accountToID;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransferContext{" +
                "accountFromID=" + accountFromID +
                ", accountToID=" + accountToID +
                ", amount=" + amount +
                '}';
    }
}
