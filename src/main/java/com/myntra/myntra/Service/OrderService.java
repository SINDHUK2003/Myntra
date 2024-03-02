package com.myntra.myntra.Service;

import com.myntra.myntra.Entity.Order;
import com.myntra.myntra.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrderById(int id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(int id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrderStatus(int id, String newStatus) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            order.setOrderStatus(newStatus);
            return orderRepository.save(order);
        }
        return null; // or throw an exception
    }

    public BigDecimal calculateTotalRevenue() {
        List<Order> orders = orderRepository.findAll();
        BigDecimal totalRevenue = BigDecimal.ZERO;
        for (Order order : orders) {
            totalRevenue = totalRevenue.add(order.getTotalPrice());
        }
        return totalRevenue;
    }

    public String trackShipping(int id) {
        Optional<Order> optionalOrder = orderRepository.findById(id);
        if (optionalOrder.isPresent()) {
            Order order = optionalOrder.get();
            return order.getTrackingInformation();
        }
        return null;
    }

    public List<Order> getOrdersByStatus(String status) {
        return orderRepository.findByOrderStatus(status);
    }

    public List<Order> getOrdersByShippingMethod(String shippingMethod) {
        return orderRepository.findByShippingMethod(shippingMethod);
    }
}