package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/createProduct/{profileId}")
    public Product createProduct(@PathVariable("profileId") int profileId, @RequestBody Product product) {
        Category category = product.getCategory();
        Gallery gallery = product.getGallery();
        return productService.createProduct(profileId, product, category, gallery);
    }

    @DeleteMapping("/deleteProduct/{profileId}/{productId}")
    public String deleteProduct(@PathVariable("profileId") int profileId, @PathVariable("productId") int productId) {
        productService.deleteProduct(profileId, productId);
        return "Product deleted!";
    }

    @PutMapping("/updateProduct/{profileId}/{productId}")
    public Product updateProduct(@PathVariable("profileId") int profileId, @PathVariable("productId") int productId, @RequestBody Product product) {
        return productService.updateProduct(profileId, productId, product);
    }

    @GetMapping("/getProduct/{productId}")
    public Product getProduct(@PathVariable("productId") int productId) {
        return productService.getProduct(productId);
    }
    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/searchProductByName")
    public List<Product> searchProductByName(@RequestParam("productname") String productname) {
        return productService.searchProductByName(productname);
    }

    @GetMapping("/ProductsAboveMRP/{price}")
    public List<Product> ProductsAboveMRP(@PathVariable float price) {
        return productService.ProductsAboveMRP(price);
    }

    @GetMapping("/ProductsBelowMRP/{price}")
    public List<Product> ProductsBelowMRP(@PathVariable float price) {
        return productService.ProductsBelowMRP(price);
    }

    @GetMapping("/SearchProductsByBrand/{brand}")
    public List<Product> SearchProductsByBrand(@PathVariable String brand) {
        return productService.SearchProductsByBrand(brand);
    }

    @GetMapping("/ProductsByPriceRange")
    public List<Product> findProductsByPriceRange(@RequestParam float startPrice, @RequestParam float endPrice) {
        return productService.findProductsByPriceRange(startPrice, endPrice);
    }

    @GetMapping("/searchProductByCategory/{category}")
    public List<Product> searchProductByCategory(@PathVariable String category) {
        return productService.searchProductByCategory(category);
    }

}
