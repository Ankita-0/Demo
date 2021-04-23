package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MController {
    @Autowired
    MService mserv;

    @Autowired
    CartService cserv;


    @GetMapping(value = "/batches/{batchid}/products")
    List<Manufacturer> findByBatch_id(@PathVariable int batchid){
        return mserv.findAllManufacturerByBatchid(batchid);
    }

    @GetMapping(value = "/batches/{batchid}/products/{id}")
    Manufacturer findbyid(@PathVariable int batchid, @PathVariable int id){
        return mserv.findManufacturerById(id);
    }

    @PostMapping("/carts")
    String addToCart(@RequestBody Cart cart){
        return cserv.addToCart(cart);
    }

    @GetMapping(value = "/cartItems")
    public Iterable<Cart> findAll(){
        return cserv.findAll();
    }
}
