package com.myApplication.product;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    @Autowired
    MService mserv;
    @Autowired
    ProductRepository prepo;
    @Autowired
    MRepo mrepo;

    public Iterable<Product> findAll() {
        return prepo.findAll();
    }
    
}

