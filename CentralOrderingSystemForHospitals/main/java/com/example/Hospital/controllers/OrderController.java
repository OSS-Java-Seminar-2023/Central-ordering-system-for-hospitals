package com.example.Hospital.controllers;

import com.example.Hospital.models.*;
import com.example.Hospital.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServices orderServices;

    @GetMapping
    public String getAllOrders(Model model) {
        List<Order> orders = orderServices.getAllOrders();
        model.addAttribute("orders", orders);
        return "order/list";  // Assuming you have a Thymeleaf template named "order/list.html"
    }

    @GetMapping("/{id}")
    public String getOrderById(@PathVariable String id, Model model) {
        Optional<Order> order = orderServices.getOrderById(id);
        order.ifPresent(o -> model.addAttribute("order", o));
        return "order/details";  // Assuming you have a Thymeleaf template named "order/details.html"
    }

    @GetMapping("/search")
    public String searchOrders(
            @RequestParam(required = false) String userId,
            @RequestParam(required = false) String resultId,
            Model model
            // Add more parameters if needed
    ) {
        List<Order> orders = orderServices.searchOrders(userId, resultId);
        model.addAttribute("orders", orders);
        return "order/list";  // Assuming you have a Thymeleaf template named "order/list.html"
    }

    @PostMapping
    public String createOrder(@ModelAttribute("order") Order order) {
        Order createdOrder = orderServices.saveOrder(order);
        return "redirect:/orders/" + createdOrder.getId();
    }

    @PutMapping("/{orderId}/addResult")
    public String updateResultForOrder(
            @PathVariable String orderId,
            @ModelAttribute("result") Result result,
            Model model
    ) {
        orderServices.updateResultForOrder(orderId, result);
        return "redirect:/orders/" + orderId;
    }

    @DeleteMapping("/{id}")
    public String deleteOrder(@PathVariable String id) {
        orderServices.deleteOrder(id);
        return "redirect:/orders";
    }
}
