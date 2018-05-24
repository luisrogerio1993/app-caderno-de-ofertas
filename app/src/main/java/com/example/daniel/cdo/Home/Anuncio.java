package com.example.daniel.cdo.Home;

import com.google.gson.annotations.SerializedName;

public class Anuncio {

    @SerializedName("id")
    private int idAnuncio;

    @SerializedName("image")
    private String urlImg;

    @SerializedName("nome")
    private String nome;

    @SerializedName("descricao")
    private String descricao;

    @SerializedName("valor_atual")
    private String valor_atual;

    @SerializedName("valor_original")
    private String valor_original;

    public Anuncio() {}

    public Anuncio(String urlImg, String nome, String descricao, String valor_atual, String valor_original) {
        this.urlImg = urlImg;
        this.nome = nome;
        this.descricao = descricao;
        this.valor_atual = valor_atual;
        this.valor_original = valor_original;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getValor_atual() {
        return valor_atual;
    }

    public void setValor_atual(String valor_atual) {
        this.valor_atual = valor_atual;
    }

    public String getValor_original() {
        return valor_original;
    }

    public void setValor_original(String valor_original) {
        this.valor_original = valor_original;
    }
}
