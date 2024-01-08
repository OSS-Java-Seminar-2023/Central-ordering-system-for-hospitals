package com.example.Hospital.services;

import com.example.Hospital.models.*;
import com.example.Hospital.repositories.OrderRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import com.example.Hospital.services.Spec.OrderSpecification;

import javax.transaction.Transactional;
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

    @Transactional
    public void updateResultForOrder(String orderId, Result result) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with ID: " + orderId));

        // Assuming Result has an ID field, set the result and update the order
        order.setResult(result);
        orderRepository.save(order);
    }

    public List<Order> searchOrders(String userId, String resultId) {
        Specification<Order> spec = Specification.where(null);

        if (userId != null && !userId.isEmpty()) {
            spec = spec.and(OrderSpecification.withUserId(userId));
        }

        if (resultId != null && !resultId.isEmpty()) {
            spec = spec.and(OrderSpecification.withResultId(resultId));
        }

        // If needed we can add some more parameters;

        return orderRepository.findAll(spec);
    }
    public void deleteOrder(String orderId){
        orderRepository.deleteById(orderId);
    }
}