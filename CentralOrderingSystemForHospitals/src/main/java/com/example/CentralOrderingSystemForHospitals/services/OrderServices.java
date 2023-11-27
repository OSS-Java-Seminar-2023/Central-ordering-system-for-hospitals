package services;

import model.Order;
import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(String id);
    Order saveOrder(Order order);
    void deleteOrder(String id);
}
