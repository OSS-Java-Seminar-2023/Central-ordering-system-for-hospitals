package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {

    OrderRepository orderRepository;
    public List<Order> getAllOrders(){
        return orderRepository.findAll();
    }
    public Optional<Order> getOrderById(String id){
        return orderRepository.findById(id);
    }
    public Order saveOrder(Order order){
        return orderRepository.save(order);
    }
    public void deleteOrder(Order order){
        orderRepository.delete(order);
    }
}
