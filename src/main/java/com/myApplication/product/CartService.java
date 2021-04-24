package com.myApplication.product;

import com.myApplication.product.Exception.ItemNotFoundInCartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepo crepo;

    public Cart getProduct(int id){
        return crepo.findById(id).orElseThrow(() -> new ItemNotFoundInCartException("Item "+id+" not found in cart"));
    }

    public String addToCart(Cart cart){
        //Cart c=getProduct(cart.getId());
        if(crepo.existsById(cart.getId())){
            //int q=cart.getQuantity();
            crepo.deleteById(cart.getId());
            cart.setQuantity(cart.getQuantity()+1);
        }
        crepo.save(cart);
        return "Added to Cart";
    }

    public Iterable<Cart> findAll(){
        return crepo.findAll();
    }

    public String delete(int id){
        if(crepo.existsById(id)){
            crepo.deleteById(id);
            return "Removed from Cart";
    }
        else{
            throw new ItemNotFoundInCartException("Item "+id+" not found in cart");
        }
    }
}
