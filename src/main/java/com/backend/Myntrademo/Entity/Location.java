package com.backend.Myntrademo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "LocationId")
    private Integer locationid;

    @Column(name = "Name")
    private String name;

    @Column(name = "BuildingNumber")
    private String buildingnumber;

    @Column(name = "Locality")
    private String locality;

    @Column(name = "District")
    private String district;

    @Column(name = "Pincode")
    private Integer pincode;

    @Column(name = "State")
    private String state;

    @Column(name = "TypeOfAddress")
    private String typeofaddress;

}
