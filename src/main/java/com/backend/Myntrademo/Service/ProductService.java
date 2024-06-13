package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Category;
import com.backend.Myntrademo.Entity.Gallery;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Repository.CategoryRepo;
import com.backend.Myntrademo.Repository.GalleryRepo;
import com.backend.Myntrademo.Repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private GalleryRepo galleryRepo;

    @Autowired
    private ProfileService profileService;

    public Product createProduct(int profileId, Product product, Category category, Gallery gallery) {
        if (profileService.isSellerLoggedIn(profileId)) {
            product.setCategory(category);
            product.setGallery(gallery);

            if(category != null) {
                categoryRepo.save(category);
            }
            if(gallery != null) {
                galleryRepo.save(gallery);
            }

            return productRepo.save(product);
        } else {
            throw new IllegalArgumentException("Only logged-in sellers can create products.");
        }
    }

    public void deleteProduct(int profileId, int productId) {
        if (profileService.isEmpSelAdmin(profileId)) {
            productRepo.deleteById(productId);
        } else {
            throw new IllegalArgumentException("Only logged-in employees or sellers can delete products.");
        }
    }

    public Product updateProduct(int profileId, int productId, Product product) {
        if (profileService.isSellerLoggedIn(profileId)) {
            Product product1 = productRepo.findById(productId).orElseThrow(() -> new RuntimeException("Product not found with ProductId : " + productId));

            product1.setProductname(product.getProductname());
            product1.setDescription((product.getDescription()));
            product1.setBrand(product.getBrand());
            product1.setSize(product.getSize());
            product1.setMrp(product.getMrp());
            product1.setStock(product.getStock());

            return productRepo.save(product1);
        } else {
            throw new IllegalArgumentException("Only logged-in employees or sellers can update products.");
        }
    }

    public Product getProduct(int productId) {
        Optional<Product> dispProduct = productRepo.findById(productId);
        return dispProduct.orElse(null);
    }

    public List<Product> getAllProduct() {
        return productRepo.findAll();
    }

    public List<Product> searchProductByName(String productname) {
        return productRepo.findByProductname(productname);
    }

    public List<Product> ProductsAboveMRP(float price) {
        return productRepo.MrpGreaterThan(price);
    }

    public List<Product> ProductsBelowMRP(float price) {
        return productRepo.MrpLessThan(price);
    }

    public List<Product> SearchProductsByBrand(String brand) {
        return productRepo.findByBrand(brand);
    }

    public List<Product> findProductsByPriceRange(float startPrice, float endPrice) {
        return productRepo.findProductsByMrpBetween(startPrice, endPrice);
    }

    public List<Product> searchProductByCategory(String category) {
        return productRepo.findByCategoryMaincategory(category);
    }


}



//    public List<Product> searchProductByBrand(String brand)
//    {
//        return productRepo.findByProductbrand(brand);
//    }

//    public List<Product> searchProductByCategory(String category)
//    {
//        return productRepo.findByCategory(category);
//    }
//
//public Product createProduct(Product product, Category category, Gallery gallery)
//{
//    product.setCategory(category);
//    product.setGallery(gallery);
//
//    if(category != null)
//    {
//        categoryRepo.save(category);
//    }
//    if(gallery != null)
//    {
//        galleryRepo.save(gallery);
//    }
//
//    return productRepo.save(product);
//}

//public void deleteProduct(int productid) {
//    productRepo.deleteById(productid);
//}
//public Product updateProduct(int productid, Product product) {
//    Product product1 = productRepo.findById(productid).orElseThrow(() -> new RuntimeException("Product not found with ProductId : " + productid));
//
//    product1.setProductname(product.getProductname());
//    product1.setDescription((product.getDescription()));
//    product1.setBrand(product.getBrand());
//    product1.setSize(product.getSize());
//    product1.setMrp(product.getMrp());
//    product1.setStock(product.getStock());
//
//    return productRepo.save(product1);
//
//}

