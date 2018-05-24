package com.example.daniel.cdo.Categorias;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CategoriaList {

    @SerializedName("data")
    private List<Categoria> categorias;

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
