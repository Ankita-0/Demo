package com.myApplication.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Products")
@Getter
@Setter

public class Manufacturer{
    @Id
    private int id;
    @Column(name="name")
    private String name;
    @Column(name="price")
    private double price;

    public Manufacturer(int id, String name, double price){
        super();
        this.id=id;
        this.name=name;
        this.price=price;
    }
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id=id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public double getPrice(){ return price; }
    public void setPrice(int price){ this.price=price; }
}
