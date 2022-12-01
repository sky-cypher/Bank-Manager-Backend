package com.examplewe.bankmanager.repo;

import com.examplewe.bankmanager.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<Customer, Long> {
}
