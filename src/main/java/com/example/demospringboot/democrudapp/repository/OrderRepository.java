package com.example.demospringboot.democrudapp.repository;

import com.example.demospringboot.democrudapp.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> getOrdersByDate(LocalDate date);
}
