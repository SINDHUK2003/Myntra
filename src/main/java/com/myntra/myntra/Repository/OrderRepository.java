package com.myntra.myntra.Repository;

import com.myntra.myntra.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> findByOrderStatus(String status);
    List<Order> findByShippingMethod(String shippingMethod);
}