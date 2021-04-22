package com.myApplication.product;

import lombok.Data;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Manufacturer")

public @Data class Manufacturer{
    @Id
    @Column
    private int id;
    private @Column String name;
    private @Column double price;

    public Manufacturer(int id, String name, double price){
        super();
        this.id=id;
        this.name=name;
        this.price=price;
    }

}
