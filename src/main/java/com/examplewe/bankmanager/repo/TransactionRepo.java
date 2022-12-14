package com.examplewe.bankmanager.repo;

import com.examplewe.bankmanager.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepo extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByAccountToID(long id);

    List<Transaction> findAllByAccountFromID(long id);
}
