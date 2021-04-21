package com.myApplication.product;

import java.util.ArrayList;

public class Product {
    private int batch_id;
    private String name;
    private String batch;
    private double price;
    private int quantity;
    private ArrayList<Manufacturer> products;
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
    public int getBatch_id(){
        return batch_id;
    }
    public void setBatch_id(int batch_id){
        this.batch_id=batch_id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getBatch(){
        return batch;
    }
    public void setBatch(String batch){
        this.batch=batch;
    }
    public double getPrice(){
        return price;
    }
    public void setPrice(double price){
        this.price=price;
    }
    public int getQuantity(){
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public ArrayList<Manufacturer> getproducts(){
        return products;
    }
    public void setproducts(ArrayList<Manufacturer> products){
        this.products=products;
    }
}