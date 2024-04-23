package com.backend.Myntrademo.DTO;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductDTO {

    private Product product;
    private Category category;
}
