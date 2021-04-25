package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class MController {
    @Autowired
    MService mserv;

    @Autowired
    ProductService service;

    @GetMapping(value = "/batches")
    public List<Product> findAll() {
        return StreamSupport
                .stream(service.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }

    @GetMapping(value = "/batches/{batchid}/products")
    List<Manufacturer> findByBatchid(@PathVariable int batchid){
        return mserv.findAllManufacturerByBatchid(batchid);
    }

    @GetMapping(value = "/batches/{batchid}/products/{id}")
    Manufacturer findbyid(@PathVariable int batchid, @PathVariable int id){
        return mserv.findManufacturerById(batchid, id);
    }
}
