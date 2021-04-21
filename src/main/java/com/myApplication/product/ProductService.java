package com.myApplication.product;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ProductService implements PService{


    public static List<Product> allProducts() {

        ArrayList<Manufacturer> mobiles = new ArrayList<>();
        mobiles.add(new Manufacturer(11, "Samsung", 50000));
        mobiles.add(new Manufacturer(12, "Apple", 120000));

        ArrayList<Manufacturer> laptop = new ArrayList<>();
        laptop.add(new Manufacturer(21,"HP", 68000));
        laptop.add(new Manufacturer(22,"Dell", 70000));

        ArrayList<Manufacturer> refrigerator = new ArrayList<>();
        refrigerator.add(new Manufacturer(31, "Samsung", 60000));
        refrigerator.add(new Manufacturer(32, "Whirlpool", 58000));

        ArrayList<Manufacturer> desktop = new ArrayList<>();
        desktop.add(new Manufacturer(41, "Dell", 90000));
        desktop.add(new Manufacturer(42, "ASUS", 70000));

        ArrayList<Manufacturer> tv = new ArrayList<>();
        tv.add(new Manufacturer(51, "Sony", 80000));
        tv.add(new Manufacturer(52, "Samsung", 80000));


        ArrayList<Product> products = new ArrayList<Product>();
        products.add(new Product(1, "Mobile", "6757Khf", 50000.00, 5, mobiles));
        products.add(new Product(2, "Laptop", "23gvKH", 900000.00, 2, laptop));
        products.add(new Product(3, "Refrigerator", "9809FSd", 80000.00, 3, refrigerator));
        products.add(new Product(4, "Desktop", "9805Agh", 120000.00, 4, desktop));
        products.add(new Product(5, "TV", "1324FSd", 100000.00, 2, tv));


        return products;

    }
    public static List<Manufacturer> getProduct(int batch_id, int id) {
        return allProducts().stream().flatMap(p->p.getproducts().stream()).filter(pr->pr.getId()==id).collect(Collectors.toList());
    }
}
