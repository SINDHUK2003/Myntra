package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.DTO.CreateProductDTO;
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

    @PostMapping("/createProduct")
    public Product createProduct(@RequestBody CreateProductDTO createProductDTO)
    {
        Product product = createProductDTO.getProduct();
        Category category = createProductDTO.getCategory();
        Gallery gallery = createProductDTO.getGallery();

        return productService.createProduct(product, category, gallery);
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

    @GetMapping("/getAllProducts")
    public List<Product> getAllProducts() {
        return productService.getAllProduct();
    }

    @GetMapping("/searchProductByName")
    public List<Product> searchProductByName(@RequestParam("productname") String productname) {
        return productService.searchProductByName(productname);
    }

//    @GetMapping("/searchProductByBrand")
//    public List<Product> searchProductByBrand(@RequestParam("brand") String brand) {
//        return productService.searchProductByBrand(brand);
//    }

//    @GetMapping("/searchProductByCategory")
//    public List<Product> searchProductByCategory(@RequestParam("category") String category) {
//        return productService.searchProductByCategory(category);
//    }
//





}
