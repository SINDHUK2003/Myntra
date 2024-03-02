package com.myntra.myntra.Entity;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "payments")
public class PaymentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID")
    private int paymentId;

    @Column(name = "Order_ID")
    private int orderId;

    @Column(name = "Payment_Method")
    private String paymentMethod;

    @Column(name = "Credit_Card_Last_Four")
    private String creditCardLastFour;

    @Column(name = "Credit_Card_Expiration_Date")
    private String creditCardExpirationDate;

    @Column(name = "Transaction_ID")
    private String transactionId;

    @Column(name = "Payment_Status")
    private String paymentStatus;

    @Column(name = "Payment_Date")
    private Timestamp paymentDate;

    // Getters and setters
    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCreditCardLastFour() {
        return creditCardLastFour;
    }

    public void setCreditCardLastFour(String creditCardLastFour) {
        this.creditCardLastFour = creditCardLastFour;
    }

    public String getCreditCardExpirationDate() {
        return creditCardExpirationDate;
    }

    public void setCreditCardExpirationDate(String creditCardExpirationDate) {
        this.creditCardExpirationDate = creditCardExpirationDate;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public Timestamp getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Timestamp paymentDate) {
        this.paymentDate = paymentDate;
    }
}
