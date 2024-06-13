package com.backend.Myntrademo.Controller;

import com.backend.Myntrademo.Entity.Cart;
import com.backend.Myntrademo.Entity.Order;
import com.backend.Myntrademo.Service.CartService;
import com.backend.Myntrademo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/createCart/{profileId}")
    public Cart createCart(@PathVariable("profileId") int profileId, @RequestBody Cart cart) {
        return cartService.createCart(profileId, cart);
    }

    @DeleteMapping("/deleteCart/{profileId}/{cartid}")
    public String deleteCart(@PathVariable("profileId") int profileId, @PathVariable("cartid") int cartid) {
        cartService.deleteCart(profileId, cartid);
        return "Product Removed From Cart!";
    }

    @PutMapping("/updateCart/{profileId}/{cartid}")
    public Cart updateCart(@PathVariable("profileId") int profileId, @PathVariable("cartid") int cartid, @RequestBody Cart cart) {
        return cartService.updateCart(profileId, cartid, cart);
    }

    @PutMapping("/updateCartItemQuantity/{profileId}/{cartid}/{productid}")
    public void updateCartItemQuantity(@PathVariable("profileId") int profileId, @PathVariable int cartid, @PathVariable int productid, @RequestParam int newQuantity) {
        cartService.updateCartItemQuantity(profileId, cartid, productid, newQuantity);
    }

    @DeleteMapping("/deleteCartItem/{profileId}/{cartid}/{productid}")
    public void deleteCartItem(@PathVariable int profileId, @PathVariable int cartid, @PathVariable int productid) {
        cartService.deleteCartItem(profileId, cartid, productid);
    }

    //-----
    @GetMapping("/getCart/{cartid}")
    public Cart getCart(@PathVariable("cartid") int cartid)
    {
        return cartService.getCart(cartid);
    }


    @GetMapping("/getCartByProfileId/{profileId}")
    public List<Cart> getCartByProfileId(@PathVariable("profileId") int profileId) {
        return cartService.getCartByProfileId(profileId);
    }

    @GetMapping("/getCartTotalByCartId/{profileId}/{cartId}")
    public float getCartTotalByCartId(@PathVariable("profileId") int profileId, @PathVariable("cartId") int cartId) {
        return cartService.getCartTotalByCartId(profileId, cartId);
    }




}
