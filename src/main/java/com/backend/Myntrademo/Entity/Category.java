package com.backend.Myntrademo.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
@Table(name = "Category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryId")
    private Integer categoryid;

    @Column(name = "MainCategory")
    private String maincategory;

    @Column(name = "SubCategory1")
    private String subcategory1;

    @Column(name = "SubCategory2")
    private String subcategory2;

    @Column(name = "SubCategory3")
    private String subcategory3;

    @Column(name = "SubCategory4")
    private String subcategory4;

    @Column(name = "SubCategory5")
    private String subcategory5;

}
