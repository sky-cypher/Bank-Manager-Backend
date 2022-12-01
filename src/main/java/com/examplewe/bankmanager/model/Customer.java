package com.examplewe.bankmanager.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
                    generator = "customer_id")
    @SequenceGenerator(name = "customer_id", allocationSize = 1)
    @Column(nullable = false, updatable = false)
    private long customerID;
    private String name;
    private String phone;
    private String email;
    private LocalDate dob;
    @Transient
    private int age;

    public int getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public Customer() {
    }

    public Customer(long customerID,
                    String name,
                    String phone,
                    String email,
                    LocalDate dob) {
        this.customerID = customerID;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public Customer(String name, String phone, String email, LocalDate dob) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dob = dob;
    }

    public long getCustomerID() {
        return customerID;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerID=" + this.getCustomerID() +
                ", name='" + this.getName() + '\'' +
                ", phone='" + this.getPhone() + '\'' +
                ", email='" + this.getEmail() + '\'' +
                ", dob=" + this.getDob() +
                ", age=" + this.getAge() +
                '}';
    }
}
