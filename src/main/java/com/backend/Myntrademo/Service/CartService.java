package com.backend.Myntrademo.Service;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Repository.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepo cartRepo;

    public Cart createCart(Cart cart)
    {
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


}
