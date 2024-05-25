package com.backend.Myntrademo.Entity;

import jakarta.persistence.*;
import lombok.*;
import com.backend.Myntrademo.Enum.CartStatus;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CartId")
    private Integer cartid;

    @ManyToOne
    @JoinColumn(name = "ProfileId")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "ProductId")
    private Product product;

    @Column(name = "Quantity")
    private Integer quantity;

    @Enumerated(EnumType.STRING)
    @Column(name = "CartStatus")
    private CartStatus cartstatus;


}
