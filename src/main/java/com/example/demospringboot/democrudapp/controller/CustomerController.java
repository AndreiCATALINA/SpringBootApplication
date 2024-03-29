package com.example.demospringboot.democrudapp.controller;

import ch.qos.logback.core.net.server.Client;
import com.example.demospringboot.democrudapp.exception.ResourceNotFoundException;
import com.example.demospringboot.democrudapp.model.Customer;
import com.example.demospringboot.democrudapp.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping //http://localhost:8081/api/customers
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customersList = customerService.getAllCustomers();
        if (customersList.isEmpty()) {
            throw new ResourceNotFoundException("The DB doesn't contain any customers");
        }
        return new ResponseEntity<>(customersList, HttpStatus.OK);
    }

    @GetMapping("/customersById/{id}") //http://localhost:8081/api/customers/customersById/{id}
    public ResponseEntity<Optional<Customer>> getAllCustomerById(@PathVariable Long id) {
        Optional<Customer> customerById = customerService.getCustomerById(id);
        customerById.orElseThrow(() ->
                new ResourceNotFoundException("The customer with id : " + id + " doesn't exist in DB"));
        return new ResponseEntity<>(customerById, HttpStatus.OK);
    }

    @GetMapping("/customersByName/{name}") //http://localhost:8081/api/customers/customersByName/{name}
    public ResponseEntity<List<Customer>> getAllCustomersByName(@PathVariable String name) {
        List<Customer> customersByName = customerService.getCustomersByName(name);
        if (customersByName.isEmpty()) {
            throw new ResourceNotFoundException("The client with name : " + name + " doesn't exist in DB");
        }
        return new ResponseEntity<>(customersByName, HttpStatus.OK);
    }

    @PostMapping("/addNewCustomer") //http://localhost:8081/api/customers/addNewCustomer
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.OK);
    }

    @PutMapping("/updateCustomer") //http://localhost:8081/api/customers/updateCustomer
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
        return new ResponseEntity<>(customerService.updateCustomer(customer), HttpStatus.OK);
    }

    @DeleteMapping("/deleteCustomerById/{id}") //http://localhost:8081/api/customers/deleteCustomerById/{id}
    public ResponseEntity<?> deleteCustomerById(@PathVariable Long id) {
        Optional<Customer> customerOptional = customerService.getCustomerById(id);
        customerOptional.orElseThrow(() ->
                new ResourceNotFoundException("The customer with id : " + id + " doesn't exist in DB"));
        customerService.deleteCustomerById(id);
        return new ResponseEntity<>("Customer with id: " + id + " deleted successfully", HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }
}
