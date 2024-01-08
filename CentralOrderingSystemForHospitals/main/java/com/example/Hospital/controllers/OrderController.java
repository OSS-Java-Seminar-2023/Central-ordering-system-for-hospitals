package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderServices.getAllOrders();
    }

    @GetMapping("/{id}")
    public Optional<Order> getOrderById(@PathVariable String id) {
        return orderServices.getOrderById(id);
    }

    @PostMapping


    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable String id, @RequestBody Order order) {
        return orderServices.saveOrder(order);
    }

    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderServices.saveOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @PutMapping("/{orderId}/addResult")
    public ResponseEntity<String> updateResultForOrder(@PathVariable String orderId, @RequestBody Result result) {
        orderServices.updateResultForOrder(orderId, result);
        return ResponseEntity.ok("Result added to order with ID: " + orderId);
    }


    @GetMapping("/search")
    public ResponseEntity<List<Order>> searchOrders(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String resultId
            // We can add some more if we need more parameters
            ) {
        List<Order> orders = orderServices.searchOrders(userId, resultId);
        return ResponseEntity.ok(orders);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable String id) {
        orderServices.deleteOrder(id);
    }
}