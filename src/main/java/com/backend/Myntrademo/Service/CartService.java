package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Entity.Product;
import com.backend.Myntrademo.Entity.Profile;
import com.backend.Myntrademo.Repository.CartRepo;
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

    public Cart createCart(Cart cart)
    {
        Profile profile = profileRepo.findById(cart.getProfile().getProfileid()).orElse(null);
        Product product = productRepo.findById(cart.getProduct().getProductid()).orElse(null);

        cart.setProfile(profile);
        cart.setProduct(product);

        return cartRepo.save(cart);
    }
    public void deleteCart(int cartid)
    {
        cartRepo.deleteById(cartid);
    }

    public Cart getCart(int cartid)
    {
        Optional<Cart> dispCart = cartRepo.findById(cartid);
        return dispCart.orElse(null);
    }

    public Cart updateCart(int cartid, Cart cart)
    {
        Cart cart1 = cartRepo.findById(cartid).orElseThrow(()-> new RuntimeException("Cart not found with CartId :" +cartid));
        cart1.setQuantity(cart.getQuantity());
        cart1.setCartstatus(cart.getCartstatus());

        return cartRepo.save(cart1);
    }

    public List<Cart> getCartByProfileId(int profileid)
    {
        return cartRepo.getCartByProfileId(profileid);
    }


}
