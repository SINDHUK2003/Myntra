package com.myntra.myntra.Repository;

import com.myntra.myntra.Entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Integer> {

}
