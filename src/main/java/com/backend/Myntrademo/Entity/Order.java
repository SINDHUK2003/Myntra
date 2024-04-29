//package com.backend.Myntrademo.Entity;
//
//
//import com.backend.Myntrademo.Enum.OrderStatus;
//import com.backend.Myntrademo.Enum.PaymentType;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import java.sql.Date;
//
//@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Table(name = "Order")
//public class Order {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "OrderId")
//    private Integer orderid;
//
//    @ManyToOne
//    @JoinColumn(name = "ProfileId")
//    private Profile profile;
//
//    @ManyToOne
//    @JoinColumn(name = "ProductId")
//    private Product product;
//
//    @ManyToOne
//    @JoinColumn(name = "PaymentId")
//    private Payment payment;
//
//    @Column(name = "OrderDate")
//    private Date orderdate;
//
//    @Column(name = "GrandTotal")
//    private Float grandtotal;
//
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "OrderStatus")
//    private OrderStatus orderStatus;
//
//
//}
