package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Order;
import com.backend.Myntrademo.Repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;


    public Order createOrder(Order order) {
        return orderRepo.save(order);
    }

    public Order getOrder(int orderid) {
        Optional<Order> optionalOrder = orderRepo.findById(orderid);
        return optionalOrder.orElse(null);
    }

    public Order updateOrder(int orderid, Order updatedOrder) {
        Order orderToUpdate = orderRepo.findById(orderid)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderid));

        orderToUpdate.setProfile(updatedOrder.getProfile());
        orderToUpdate.setPayment(updatedOrder.getPayment());
        orderToUpdate.setProduct(updatedOrder.getProduct());
        orderToUpdate.setOrderdate(updatedOrder.getOrderdate());
        orderToUpdate.setTotalamount(updatedOrder.getTotalamount());
        orderToUpdate.setOrderstatus(updatedOrder.getOrderstatus());

        return orderRepo.save(orderToUpdate);
    }

    public void deleteOrder(int orderid) {
        orderRepo.deleteById(orderid);
    }
}
