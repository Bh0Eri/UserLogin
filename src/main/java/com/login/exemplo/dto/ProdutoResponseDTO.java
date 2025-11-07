package com.login.exemplo.dto;

import com.login.exemplo.entity.Produto;

public class ProdutoResponseDTO {


    private String name;
    private double price;
    private int qnt;
    private double total;

    public ProdutoResponseDTO(Produto produto) {

        this.name = produto.getName();
        this.price = produto.getPrice();
        this.qnt = produto.getQnt();
        this.total = produto.getPrice()*produto.getQnt();
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

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
