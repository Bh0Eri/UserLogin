package com.login.exemplo.dto;

import com.login.exemplo.entity.Usuario;

public class UsuarioResponseDTO {

    private int id;
    private String nome;
    private String email;


    public UsuarioResponseDTO(Usuario user) {
        this.id = user.getId();
        this.nome = user.getNome();
        this.email = user.getEmail();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
