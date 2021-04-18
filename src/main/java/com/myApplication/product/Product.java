package com.myApplication.product;

public class Product {
    private int id;
    private String name;
    private String modelno;
    private String batch;
    private double price;
    private int quantity;
    public Product(){}

    public Product(int id, String name, String modelno, String batch, double price, int quantity){
        super();
        this.id=id;
        this.name=name;
        this.modelno=modelno;
        this.batch=batch;
        this.price=price;
        this.quantity=quantity;
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
    public String getModelno(){
        return modelno;
    }
    public void setModelno(String modelno){
        this.modelno=modelno;
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
}