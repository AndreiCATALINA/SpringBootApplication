package com.example.demospringboot.democrudapp.repository;

import com.example.demospringboot.democrudapp.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> getCustomersByName(String name);
}
