package com.myApplication.product;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements PService{


    public static List<Product> allProducts() {

        ArrayList<String> mobiles = new ArrayList<>();
        mobiles.add("Samsung");
        mobiles.add("Apple");

        ArrayList<String> laptop = new ArrayList<>();
        laptop.add("HP");
        laptop.add("Dell");

        ArrayList<String> refrigerator = new ArrayList<>();
        refrigerator.add("Samsung");
        refrigerator.add("Whirlpool");

        ArrayList<String> desktop = new ArrayList<>();
        desktop.add("Dell");
        desktop.add("ASUS");

        ArrayList<String> tv = new ArrayList<>();
        tv.add("Sony");
        tv.add("Samsung");


        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mobile", "VN13718968", "6757Khf", 50000.00, 5, mobiles));
        products.add(new Product(2, "Laptop", "KL1343968", "23gvKH", 900000.00, 2, laptop));
        products.add(new Product(3, "Refrigerator", "DF678968", "9809FSd", 80000.00, 3, refrigerator));
        products.add(new Product(4, "Desktop", "YF878968", "9805Agh", 120000.00, 4, desktop));
        products.add(new Product(5, "TV", "DF67854", "1324FSd", 100000.00, 2, tv));


        return products;

    }
    public static List<Product> getProduct(int id) {
        return allProducts().stream().filter(product -> product.getId()==id).collect((Collectors.toList()));
    }
}
