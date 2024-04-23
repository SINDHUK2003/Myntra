package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/createCart")
    public Cart createCart(@RequestBody Cart cart)
    {
        return cartService.createCart(cart);
    }

    @DeleteMapping("/deleteCart/{cartid}")
    public String deleteCart(@PathVariable("cartid") int cartid)
    {
        cartService.deleteCart(cartid);
        return "Product Removed From Cart!";
    }

    @GetMapping("/getCart/{cartid}")
    public Cart getCart(@PathVariable("cartid") int cartid)
    {
        return cartService.getCart(cartid);
    }

    @PutMapping("/updateCart/{cartid}")
    public Cart updateCart(@PathVariable("cartid") int cartid,@RequestBody Cart cart)
    {
        return cartService.updateCart(cartid, cart);
    }

    @GetMapping("/getCartByProfileId/{profileid}")
    public List<Cart> getCartByProfileId(@PathVariable("profileid") int profileid)
    {
        return cartService.getCartByProfileId(profileid);
    }

}
