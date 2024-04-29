package com.backend.Myntrademo.Entity;

import com.backend.Myntrademo.Enum.PaymentType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentId")
    private Integer paymentid;

    @Enumerated(EnumType.STRING)
    @Column(name = "PaymentType")
    private PaymentType paymenttype;
}
