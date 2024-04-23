package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.CreateProductDTO;
import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody CreateProductDTO createProductDTO)
    {
        Product product = createProductDTO.getProduct();
        Category category = createProductDTO.getCategory();

        return productService.createProduct(product, category);
    }

    @DeleteMapping("/deleteProduct/{productid}")
    public String deleteProduct(@PathVariable("productid") int productid)
    {
        productService.deleteProduct(productid);
        return "Product deleted!";
    }

    @GetMapping("/getProduct/{productid}")
    public Product getProduct(@PathVariable("productid") int productid)
    {
        return productService.getProduct(productid);
    }

    @PutMapping("/updateProduct/{productid}")
    public Product updateProduct(@PathVariable("productid") int productid, @RequestBody Product product)
    {
        return productService.updateProduct(productid, product);
    }




}
