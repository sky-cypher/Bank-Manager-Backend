package com.examplewe.bank.service;

import com.examplewe.bank.exception.CustomerNotFoundException;
import com.examplewe.bank.model.Customer;
import com.examplewe.bank.repo.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepo customerRepo;

    @Autowired
    public CustomerService(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer addCustomer(Customer customer){
        return customerRepo.save(customer);
    }

    public List<Customer> getCustomers(){
        return customerRepo.findAll();
    }

    public Customer getCustomer(long customerID){
        return customerRepo.findById(customerID)
                .orElseThrow(() -> new CustomerNotFoundException(customerID));
    }

    public void deleteCustomer(long accountID) {
        customerRepo.deleteById(accountID);
    }

    public Customer updateCustomer(Customer customer) {
        long id = customer.getCustomerID();
        if (customerRepo.existsById(id))
            return customerRepo.save(customer);
        else
            throw new CustomerNotFoundException(id);
    }
}
