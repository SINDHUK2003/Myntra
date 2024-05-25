package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Order;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Repository.OrderRepo;
import com.backend.Myntrademo.Repository.PaymentRepo;
import com.backend.Myntrademo.Repository.ProductRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private PaymentRepo paymentRepo;

    @Autowired
    private ProductRepo productRepo;


    public Order createOrder(Order order) {
        order.setProfile(profileRepo.findById(order.getProfile().getProfileid()).orElse(null));
        order.setPayment(paymentRepo.findById(order.getPayment().getPaymentid()).orElse(null));
        order.setProduct(productRepo.findById(order.getProduct().getProductid()).orElse(null));

        Order savedOrder = orderRepo.save(order);

        Product product = savedOrder.getProduct();
        if (product != null) {
            int currentStock = product.getStock();
            if (currentStock > 0) {
                product.setStock(currentStock - 1);
                productRepo.save(product);
            }
        }

        return savedOrder;
    }

    public Order getOrder(int orderid)
    {
        Optional<Order> optionalOrder = orderRepo.findById(orderid);
        return optionalOrder.orElse(null);
    }

    public Order updateOrder(int orderId, Order updatedOrder) {
        Order existingOrder = orderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found with id: " + orderId));

        if (updatedOrder.getProfile() != null) {
            existingOrder.setProfile(updatedOrder.getProfile());
        }
        if (updatedOrder.getPayment() != null) {
            existingOrder.setPayment(updatedOrder.getPayment());
        }
        if (updatedOrder.getProduct() != null) {
            existingOrder.setProduct(updatedOrder.getProduct());
        }
        if (updatedOrder.getOrderdate() != null) {
            existingOrder.setOrderdate(updatedOrder.getOrderdate());
        }
        if (updatedOrder.getTotalamount() != null) {
            existingOrder.setTotalamount(updatedOrder.getTotalamount());
        }
        if (updatedOrder.getOrderstatus() != null) {
            existingOrder.setOrderstatus(updatedOrder.getOrderstatus());
        }

        return orderRepo.save(existingOrder);
    }

    public void deleteOrder(int orderid)
    {
        orderRepo.deleteById(orderid);
    }
}