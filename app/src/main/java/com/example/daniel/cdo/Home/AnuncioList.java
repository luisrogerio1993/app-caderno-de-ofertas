package com.example.daniel.cdo.Home;

import com.example.daniel.cdo.Home.Anuncio;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AnuncioList {

    @SerializedName("data")
    private List<Anuncio> anuncios;

    public List<Anuncio> getAnuncios() {
        return anuncios;
    }

    public void setAnuncios(List<Anuncio> anunciosL) {
        this.anuncios = anunciosL;
    }
}
