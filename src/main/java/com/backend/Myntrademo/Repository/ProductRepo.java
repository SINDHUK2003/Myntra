package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

      List<Product> findByProductname(String productname);
      List<Product> MrpGreaterThan(float price);
      List<Product> MrpLessThan(float price);
      List<Product> findByBrand(String brand);

      @Query("SELECT p FROM Product p WHERE p.mrp BETWEEN :startPrice AND :endPrice")
      List<Product> findProductsByMrpBetween(@Param("startPrice") float startPrice, @Param("endPrice") float endPrice);

      List<Product> findByCategoryMaincategory(String mainCategory);

}
