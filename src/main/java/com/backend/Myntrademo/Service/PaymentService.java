package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Payment;
import com.backend.Myntrademo.Repository.PaymentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepo paymentRepo;

    public Payment createPayment(Payment payment)
    {
        return paymentRepo.save(payment);
    }

    public void deletePayment(int paymentid)
    {
        paymentRepo.deleteById(paymentid);
    }

    public Payment getPayment(int paymentid)
    {
        Optional<Payment> dispPayment = paymentRepo.findById(paymentid);
        return dispPayment.orElse(null);
    }

    public List<Payment> getAllPayment()
    {
        return paymentRepo.findAll();
    }




}
