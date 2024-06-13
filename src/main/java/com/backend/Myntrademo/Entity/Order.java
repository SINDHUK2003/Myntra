package com.backend.Myntrademo.Entity;

import com.backend.Myntrademo.Enum.OrderStatus;
import jakarta.persistence.*;
import lombok.*;
import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OrderId")
    private Integer orderid;

    @ManyToOne
    @JoinColumn(name = "ProfileId")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "PaymentId")
    private Payment payment;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "OrderDate")
    private Date orderdate;

    @Column(name = "TotalAmount")
    private Float totalamount;

    @Enumerated(EnumType.STRING)
    @Column(name = "OrderStatus")
    private OrderStatus orderstatus;


}