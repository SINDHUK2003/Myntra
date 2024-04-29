package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Repository.CategoryRepo;
import com.backend.Myntrademo.Repository.GalleryRepo;
import com.backend.Myntrademo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private GalleryRepo galleryRepo;

    public Product createProduct(Product product, Category category, Gallery gallery)
    {
        product.setCategory(category);
        product.setGallery(gallery);

        if(category != null)
        {
            categoryRepo.save(category);
        }
        if(gallery != null)
        {
            galleryRepo.save(gallery);
        }

        return productRepo.save(product);
    }
    public Product getProduct(int productid)
    {
        Optional<Product> dispProduct = productRepo.findById(productid);
        return dispProduct.orElse(null);
    }

    public void deleteProduct(int productid)
    {
        productRepo.deleteById(productid);
    }

    public Product updateProduct(int productid, Product product)
    {
        Product product1 = productRepo.findById(productid).orElseThrow(()-> new RuntimeException("Product not found with ProductId : " +productid));

        product1.setProductname(product.getProductname());
        product1.setDescription((product.getDescription()));
        product1.setBrand(product.getBrand());
        product1.setSize(product.getSize());
        product1.setMrp(product.getMrp());
        product1.setStock(product.getStock());

        return productRepo.save(product1);

    }




}
