package com.backend.Myntrademo.Entity;

import com.backend.Myntrademo.Enum.PaymentStatus;
import com.backend.Myntrademo.Enum.PaymentType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId")
    private Integer paymentid;

    @Column(name = "TransactionID")
    private String transactionid;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentType")
    private PaymentType paymenttype;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentStatus")
    private PaymentStatus paymentStatus;


}
