package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.model.Customer;
import com.example.demospringboot.democrudapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }

    @GetMapping("/customersById")
    public ResponseEntity<Optional<Customer>> getAllCustomersById(Long id){
        return new ResponseEntity<>(customerService.getCustomerById(id),HttpStatus.OK);
    }

    @GetMapping("/customersByName")
    public ResponseEntity<List<Customer>> getAllCustomersByName(String name){
        return new ResponseEntity<>(customerService.getCustomersByName(name),HttpStatus.OK);
    }
}
