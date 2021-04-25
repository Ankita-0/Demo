package com.myApplication.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;


@Table(name = "Products")
@Entity
public @Data class Manufacturer {

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Product.class, optional = false)
    @JoinColumn(name = "batchid", insertable = false, updatable = false)
    @JsonIgnore
    private Product product;

    @JsonIgnore
    private int batchid;

    private @Id int id;
    private String name;
    private double price;

    public Manufacturer() {
    }

    public Manufacturer(int batchid, int id, String name, double price) {
        this.batchid = batchid;
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
