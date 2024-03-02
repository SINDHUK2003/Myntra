package com.myntra.myntra.Controller;

import com.myntra.myntra.Entity.Product;
import com.myntra.myntra.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product product) {
        product.setProductId(id);
        return productService.saveProduct(product);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }
//
//    @GetMapping("/products/searchByName")
//    public List<Product> searchProductsByName(@RequestParam String name) {
//        return productService.searchProductsByName(name);
//    }
//
//    @GetMapping("/products/searchByBrand")
//    public List<Product> searchProductsByBrand(@RequestParam String brand) {
//        return productService.searchProductsByBrand(brand);
//    }
//
//    @GetMapping("/products/searchByPrice")
//    public List<Product> searchProductsByPrice(@RequestParam BigDecimal minPrice, @RequestParam BigDecimal maxPrice) {
//        return productService.searchProductsByPrice(minPrice, maxPrice);
//    }
//
//    @GetMapping("/products/searchByCategory")
//    public List<Product> searchProductsByCategory(@RequestParam String category) {
//        return productService.searchProductsByCategory(category);
//    }
}