package com.myApplication.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;


@Table(name = "Batches")
@JsonPropertyOrder({"batch_id", "name", "batch", "price", "quantity"})
@Entity
public @Data class Product implements Serializable {

    @JsonProperty("batch_id")
    private @Id int batchid;
    private  String name;
    private  String batch;
    private  double price;
    private  int quantity;
    @OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
    @ElementCollection
    private List<Manufacturer> products=new ArrayList<Manufacturer>();
    public Product(){}

    public Product(int batchid, String name, String batch, double price, int quantity){
        super();
        this.batchid=batchid;
        this.name=name;
        this.batch=batch;
        this.price=price;
        this.quantity=quantity;

    }
}