package com.myntra.myntra.Repository;

import com.myntra.myntra.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    List<Product> findByProductNameContainingIgnoreCase(String name);
//
//    List<Product> findByManufacturerBrandContainingIgnoreCase(String brand);
//
//    List<Product> findByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
//
//    List<Product> findByProductCategoryIgnoreCase(String category);

}