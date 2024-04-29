package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Payment;
import com.backend.Myntrademo.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;


    @PostMapping("/createPayment")
    public Payment createPayment(@RequestBody Payment payment)
    {
        return paymentService.createPayment(payment);
    }

    @GetMapping("/getPayment/{paymentid}")
    public Payment getPayment(@PathVariable("paymentid") int paymentid)
    {
        return paymentService.getPayment(paymentid);
    }

    @DeleteMapping("/deletePayment/{paymentid}")
    public String deletePayment(@PathVariable("paymentid") int paymentid)
    {
        paymentService.deletePayment(paymentid);
        return "Payment Deleted !";
    }

    @GetMapping("/getAllPayment")
    public List<Payment> getAllPayment()
    {
        return paymentService.getAllPayment();
    }


}
