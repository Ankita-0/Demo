package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cserv;

    @PostMapping("/add")
    String addToCart(@RequestBody Cart cart){
        return cserv.addToCart(cart);
    }

    @DeleteMapping("/cartItems/{batchid}/{id}/remove")
    String delete(@PathVariable int batchid, @PathVariable int id){
        return cserv.delete(batchid, id);
    }

    @GetMapping(value = "/cartItems")
    public Iterable<Cart> findCartItems(){
        return cserv.findAll();
    }
}
