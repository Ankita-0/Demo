package com.myApplication.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "Batches")
@JsonPropertyOrder({"batch_id", "name", "batch", "price", "quantity"})
@Entity
public @Data class Product {

    @Id
    @Column
    @JsonProperty("batch_id")
    private int batchid;
    private @Column String name;
    private @Column String batch;
    private @Column double price;
    private @Column int quantity;
    //private @Column ArrayList<Manufacturer> products;
    public Product(){}

    public Product(int batchid, String name, String batch, double price, int quantity){
        super();
        this.batchid=batchid;
        this.name=name;
        this.batch=batch;
        this.price=price;
        this.quantity=quantity;
        //this.products=products;

    }
}