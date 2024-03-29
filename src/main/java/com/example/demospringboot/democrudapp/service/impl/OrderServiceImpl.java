package com.example.demospringboot.democrudapp.service.impl;

import com.example.demospringboot.democrudapp.exception.EntityNotFoundException;
import com.example.demospringboot.democrudapp.model.Customer;
import com.example.demospringboot.democrudapp.model.Order;
import com.example.demospringboot.democrudapp.repository.CustomerRepository;
import com.example.demospringboot.democrudapp.repository.OrderRepository;
import com.example.demospringboot.democrudapp.service.OrderService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    private CustomerRepository customerRepository;

    public OrderServiceImpl(OrderRepository orderRepository, CustomerRepository customerRepository) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order updateOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public void deleteOrderById(Long id) {
     orderRepository.deleteById(id);
    }

    @Override
    public List<Order> getOrdersByDate(LocalDate date) {
        return orderRepository.getOrdersByDate(date);
    }
}
