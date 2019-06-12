package com.project.productService.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private double price;

    @NotNull
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
    public boolean getIsVegetarian() {
        return this.isVegetarian;
    }
    public void setIsVegetarian(boolean vegetarian) {
        this.isVegetarian = vegetarian;
    }
}
