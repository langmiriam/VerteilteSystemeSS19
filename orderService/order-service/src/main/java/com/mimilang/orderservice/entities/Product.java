package com.mimilang.orderservice.entities;

public class Product {

    private Long id;
    private String name;
    private double price;
    private boolean isVegetarian;

    public Product(String name, double price, boolean isVegetarian){
        this.name = name;
        this.price = price;
        this.isVegetarian = isVegetarian;
    }

    public Product() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

}
