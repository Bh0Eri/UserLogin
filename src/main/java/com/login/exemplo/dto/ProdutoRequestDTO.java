package com.login.exemplo.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class ProdutoRequestDTO {


    @NotBlank(message = "Nome não pode ser vazio!")
    private String name;

    @NotBlank(message = "Está sem preço")
    private double price;

    @NotNull(message = "Quantidade não pode ser vazio!")
    private int qnt;


    public ProdutoRequestDTO() {
    }

    public ProdutoRequestDTO(String name, double price, int qnt) {
        this.name = name;
        this.price = price;
        this.qnt = qnt;
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
