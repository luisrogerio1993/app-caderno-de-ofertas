package com.example.daniel.cdo.Categorias;

import com.google.gson.annotations.SerializedName;

public class Categoria {

    @SerializedName("id")
    private int id;

    @SerializedName("nome")
    private String nome;

    public Categoria() {}

    public Categoria(int id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
