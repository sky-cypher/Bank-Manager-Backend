package com.examplewe.bankmanager.repo;

import com.examplewe.bankmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepo extends JpaRepository<Account, Long> {
    List<Account> findAllByCustomerID(long customerID);

    void deleteAllByCustomerID(long customerID);
}
