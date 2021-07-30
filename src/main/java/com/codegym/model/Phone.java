package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int price;
    private int quantity;
    private String color;
    @ManyToOne
    @JoinColumn(name = "category_Id")
    private Category category;

    public Phone() {
    }

    public Phone(Long id, String name, int price, int quantity, String color, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getColor() {
        return color;
    }

    public Category getCategory() {
        return category;
    }
}
