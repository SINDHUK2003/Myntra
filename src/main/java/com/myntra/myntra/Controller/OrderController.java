package com.myntra.myntra.Controller;

import com.myntra.myntra.Entity.Order;
import com.myntra.myntra.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.getOrderById(id).orElse(null);
    }

    @PostMapping
    public Order addOrder(@RequestBody Order order) {
        return orderService.saveOrder(order);
    }

    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable int id, @RequestBody Order order) {
        order.setOrderId(id);
        return orderService.saveOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }

    // Additional endpoints for order management

    @PutMapping("/{id}/status/{status}")
    public Order updateOrderStatus(@PathVariable int id, @PathVariable String status) {
        return orderService.updateOrderStatus(id, status);
    }

    @GetMapping("/revenue")
    public BigDecimal calculateTotalRevenue() {
        return orderService.calculateTotalRevenue();
    }

    @GetMapping("/{id}/track")
    public String trackShipping(@PathVariable int id) {
        return orderService.trackShipping(id);
    }

    @GetMapping("/status/{status}")
    public List<Order> getOrdersByStatus(@PathVariable String status) {
        return orderService.getOrdersByStatus(status);
    }

    @GetMapping("/shipping/{method}")
    public List<Order> getOrdersByShippingMethod(@PathVariable String method) {
        return orderService.getOrdersByShippingMethod(method);
    }
}