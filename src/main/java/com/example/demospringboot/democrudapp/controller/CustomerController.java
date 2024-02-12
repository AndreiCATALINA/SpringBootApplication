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

@RequiredArgsConstructor
@RestController
@RequestMapping("api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers(){
        return new ResponseEntity<>(customerService.getAllCustomers(), HttpStatus.OK);
    }
}
