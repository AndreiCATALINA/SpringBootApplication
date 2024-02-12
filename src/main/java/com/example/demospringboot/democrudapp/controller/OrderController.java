package com.example.demospringboot.democrudapp.controller;

import com.example.demospringboot.democrudapp.model.Order;
import com.example.demospringboot.democrudapp.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/order")
public class OrderController {
    public final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders(){
        return new ResponseEntity<>(orderService.getAllOrders(), HttpStatus.OK);
    }
}
