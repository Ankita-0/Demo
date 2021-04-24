package com.myApplication.product;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    ProductRepository prepo;

    public Iterable<Product> findAll() {
        return prepo.findAll();
    }
}

