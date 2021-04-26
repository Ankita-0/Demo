package com.myApplication.product;

import com.myApplication.product.Exception.ItemNotFoundException;
import com.myApplication.product.Exception.ItemNotFoundInCartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CartService {
    @Autowired
    CartRepo crepo;
    @Autowired
    MRepo mrepo;

    public Cart getProduct(int id){
        return crepo.findById(id).orElseThrow(() -> new ItemNotFoundInCartException("Item "+id+" not found in cart"));
    }

    public String addToCart(Cart cart) {
        if(mrepo.existsByBatchidAndName(cart.getBatchid(), cart.getName()) && mrepo.existsByIdAndName(cart.getId(), cart.getName())){
            if (crepo.existsById(cart.getId())) {
                crepo.deleteById(cart.getId());
                cart.setQuantity(cart.getQuantity() + 1);
            }
            crepo.save(cart);
            return "Added to Cart";
        }
        else{
            throw new ItemNotFoundException("Product not found in the product catalog");
        }
    }

    public Iterable<Cart> findAll(){
        return crepo.findAll();
    }

    public String delete(int batchid, int id){
        if(crepo.existsByBatchidAndId(batchid, id)){
            crepo.deleteById(id);
            return "Removed from Cart";
    }
        else{
            throw new ItemNotFoundInCartException("Product not found in cart");
        }
    }
}
