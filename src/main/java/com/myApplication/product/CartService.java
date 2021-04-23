package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo crepo;

    public String addToCart(Cart cart){
        crepo.save(cart);
        return "Added to Cart";
    }

    public Iterable<Cart> findAll(){
        return crepo.findAll();
    }
}
