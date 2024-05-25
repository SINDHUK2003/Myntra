package com.backend.Myntrademo.Repository;

import com.backend.Myntrademo.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

      List<Product> findByProductname(String productname);
  //    List<Product> findByProductbrand(String brand);


//      List<Product> findByCategory(String category);
//      List<Product> findByBrand(String brand);


}
