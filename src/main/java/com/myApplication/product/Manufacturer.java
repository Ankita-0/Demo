package com.myApplication.product;

import lombok.Data;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name = "Manufacturer")
@Entity
public @Data class Manufacturer{

    private @Column int batchid;
    @Column
    private @Id int id;
    private @Column String name;
    private @Column double price;

    public Manufacturer(){}

    public Manufacturer(int batchid, int id, String name, double price){
        this.batchid=batchid;
        this.id=id;
        this.name=name;
        this.price=price;
    }
}
