package com.examplewe.bank.repo;

import com.examplewe.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomerID(long customerID);
}
