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

    @Autowired
    private ProfileService profileService;


    public Cart createCart(int profileId, Cart cart) {
        if (profileService.isUserLoggedIn(profileId)) {
            Profile profile = profileRepo.findById(profileId).orElse(null);
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
        } else {
            throw new IllegalArgumentException("Only logged-in users can create carts.");
        }
    }

    public void deleteCart(int profileId, int cartid) {
        if (profileService.isUserLoggedIn(profileId)) {
            cartRepo.deleteById(cartid);
        } else {
            throw new IllegalArgumentException("Only logged-in users can delete carts.");
        }
    }

    public Cart updateCart(int profileId, int cartid, Cart cart) {
        if (profileService.isUserLoggedIn(profileId)) {
            Cart cart1 = cartRepo.findById(cartid).orElseThrow(() -> new RuntimeException("Cart not found with CartId: " + cartid));
            cart1.setQuantity(cart.getQuantity());
            cart1.setCartstatus(cart.getCartstatus());

            return cartRepo.save(cart1);
        } else {
            throw new IllegalArgumentException("Only logged-in users can update carts.");
        }
    }

    public void updateCartItemQuantity(int profileId, int cartid, int productid, int newQuantity) {
        if (profileService.isUserLoggedIn(profileId)) {
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
        } else {
            throw new IllegalArgumentException("Only logged-in users can update cart item quantities.");
        }
    }

    public void deleteCartItem(int profileId, int cartid, int productid) {
        if (profileService.isUserLoggedIn(profileId)) {
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
        } else {
            throw new IllegalArgumentException("Only logged-in users can delete cart items.");
        }
    }



    public Cart getCart(int cartid) {
        Optional<Cart> dispCart = cartRepo.findById(cartid);
        return dispCart.orElse(null);
    }


    public List<Cart> getCartByProfileId(int profileId) {
        if (profileService.isUserLoggedIn(profileId)) {
            return cartRepo.getCartByProfileId(profileId);
        } else {
            throw new IllegalArgumentException("Only logged-in users can retrieve their carts.");
        }
    }

    public float getCartTotalByCartId(int profileId, int cartId) {
        if (profileService.isUserLoggedIn(profileId)) {
            Cart cart = cartRepo.findById(cartId).orElseThrow(() -> new RuntimeException("Cart not found with CartId: " + cartId));

            return cart.getProduct().getMrp() * cart.getQuantity();
        } else {
            throw new IllegalArgumentException("Only logged-in users can retrieve their cart total.");
        }
    }



}

