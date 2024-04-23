package com.backend.Myntrademo.Entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Contact")
public class MobileNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MobileNumberId")
    private Integer mobilenumberid;

    @Column(name = "CountryCode")
    private String countrycode;

    @Column(name = "MobileNumber")
    private String mobilenumber;

    @Column(name = "AlternateNumber")
    private String alternatenumber;
}
