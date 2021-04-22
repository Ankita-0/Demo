package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService service;

    @GetMapping(value="/batches")
    public Iterable<Product> findAll(){
            return service.findAll();
    }
  //  @GetMapping("/batches/{batch_id}/products/{id}")
  //  public List<Manufacturer> getProductById(@PathVariable int batch_id, @PathVariable int id){ return ProductService.getProduct(batch_id, id);}
}
