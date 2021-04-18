package com.myApplication.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping(value="/product")
    public List<Product> getProduct(){
        List<Product> products=ProductService.allProducts();
            return products;
    }
    @GetMapping("/product/{id}")
    public List<Product> getProductById(@PathVariable int id){
        return ProductService.getProduct(id);
    }
}
