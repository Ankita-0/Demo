package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cserv;

    @PostMapping("/carts")
    String addToCart(@RequestBody Cart cart){
        return cserv.addToCart(cart);
    }

    @GetMapping(value = "/cartItems")
    public Iterable<Cart> findCartItems(){
        return cserv.findAll();
    }
}
