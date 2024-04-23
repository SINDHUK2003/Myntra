package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @PutMapping("/createCart")
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

}
