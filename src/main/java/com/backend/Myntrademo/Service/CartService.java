package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Entity.Order;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Enum.OrderStatus;
import com.backend.Myntrademo.Repository.CartRepo;
import com.backend.Myntrademo.Repository.OrderRepo;
import com.backend.Myntrademo.Repository.ProductRepo;
import com.backend.Myntrademo.Repository.ProfileRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProfileRepo profileRepo;

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private OrderRepo orderRepo;


    public Cart createCart(Cart cart) {
        Profile profile = profileRepo.findById(cart.getProfile().getProfileid()).orElse(null);
        Product product = productRepo.findById(cart.getProduct().getProductid()).orElse(null);

        if (profile == null || product == null) {
            throw new RuntimeException("Profile or Product not found.");
        }

        if (product.getStock() <= 0) {
            throw new RuntimeException("Product out of stock.");
        }

        cart.setProfile(profile);
        cart.setProduct(product);

        return cartRepo.save(cart);
    }

    public void deleteCart(int cartid) {
        cartRepo.deleteById(cartid);
    }

    public Cart getCart(int cartid) {
        Optional<Cart> dispCart = cartRepo.findById(cartid);
        return dispCart.orElse(null);
    }

    public Cart updateCart(int cartid, Cart cart) {
        Cart cart1 = cartRepo.findById(cartid).orElseThrow(() -> new RuntimeException("Cart not found with CartId :" + cartid));
        cart1.setQuantity(cart.getQuantity());
        cart1.setCartstatus(cart.getCartstatus());

        return cartRepo.save(cart1);
    }

    public List<Cart> getCartByProfileId(int profileId) {
        return cartRepo.getCartByProfileId(profileId);
    }


    public void deleteCartItem(int cartid, int productid) {
        Optional<Cart> optionalCart = cartRepo.findById(cartid);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            if (cart.getProduct().getProductid() == productid) {
                cartRepo.delete(cart);
            } else {
                throw new RuntimeException("Product with id " + productid + " not found in cart with id " + cartid);
            }
        } else {
            throw new RuntimeException("Cart with id " + cartid + " not found");
        }
    }

    public void updateCartItemQuantity(int cartid, int productid, int newQuantity) {
        Optional<Cart> optionalCart = cartRepo.findById(cartid);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            if (cart.getProduct().getProductid() == productid) {
                int currentStock = cart.getProduct().getStock();
                if (newQuantity <= currentStock) {
                    cart.setQuantity(newQuantity);
                    cartRepo.save(cart);
                } else {
                    throw new RuntimeException("Requested quantity exceeds available stock. Current stock: " + currentStock);
                }
            } else {
                throw new RuntimeException("Product with id " + productid + " not found in cart with id " + cartid);
            }
        } else {
            throw new RuntimeException("Cart with id " + cartid + " not found");
        }
    }



    public float getCartTotalByCartId(int cartId) {
        Cart cart = cartRepo.findById(cartId)
                .orElseThrow(() -> new RuntimeException("Cart not found with CartId: " + cartId));

        return cart.getProduct().getMrp() * cart.getQuantity();
    }


}

