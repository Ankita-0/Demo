package com.myApplication.product;

import lombok.Data;
import java.util.ArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name= "CartItems")
@Entity
public @Data class Cart {

    private @Column int batchid;
    @Column
    private @Id int id;
    private @Column String name;
    private @Column double price;

    public Cart(){}

    public Cart(int batchid, int id, String name, double price){
        this.batchid=batchid;
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
