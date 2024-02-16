package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.model.Order;
import com.example.demospringboot.democrudapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/order")
public class OrderController {
    public final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }

    @GetMapping("/ordersById")
    public ResponseEntity<Optional<Order>> getAllOrdersById(Long id){
        return new ResponseEntity<>(orderService.getOrderById(id),HttpStatus.OK);
    }

    @GetMapping("/ordersByDate")
    public ResponseEntity<List<Order>> getAllOrdersByDate(LocalDate date){
        return new ResponseEntity<>(orderService.getOrdersByDate(date),HttpStatus.OK);
    }
}
