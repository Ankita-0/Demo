package com.myApplication.product;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements PService{

    public static List<Product> allProducts() {
        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mobile", "VN13718968", "6757Khf", 50000.00, 5));
        products.add(new Product(2, "Laptop", "KL1343968", "23gvKH", 900000.00, 2));
        products.add(new Product(3, "TV", "DF678968", "9809FSd", 120000.00, 3));
        return products;

    }
    public static List<Product> getProduct(int id) {
        return allProducts().stream().filter(product -> product.getId()==id).collect((Collectors.toList()));
    }
}
