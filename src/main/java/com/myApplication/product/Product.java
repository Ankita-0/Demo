package com.myApplication.product;

import lombok.Data;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Batches")

public @Data class Product {
    @Id
    @Column
    private int batch_id;
    private @Column String name;
    private @Column String batch;
    private @Column double price;
    private @Column int quantity;
    private @Column ArrayList<Manufacturer> products;
    public Product(){}

    public Product(int batch_id, String name, String batch, double price, int quantity, ArrayList<Manufacturer> products){
        super();
        this.batch_id=batch_id;
        this.name=name;
        this.batch=batch;
        this.price=price;
        this.quantity=quantity;
        this.products=products;
    }
}