package com.login.exemplo.entity;


import jakarta.persistence.*;
import org.hibernate.bytecode.enhance.spi.EnhancementInfo;
import org.springframework.data.repository.cdi.Eager;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private double price;
    @Column(length = 100)
    private int qnt;


    public Produto() {
    }

    public Produto(int id, String name, double price, int qnt) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qnt = qnt;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQnt() {
        return qnt;
    }

    public void setQnt(int qnt) {
        this.qnt = qnt;
    }
}
