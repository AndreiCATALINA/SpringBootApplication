package com.example.demospringboot.democrudapp.service;

import com.example.demospringboot.democrudapp.model.Order;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    Optional<Order> getOrderById(Long id);
    List<Order> getAllOrders();
    Order saveOrder(Order order);
    Order updateOrder(Order order);
    void deleteOrderById(Long id);
    List<Order> getOrdersByDate(LocalDate date);
}
