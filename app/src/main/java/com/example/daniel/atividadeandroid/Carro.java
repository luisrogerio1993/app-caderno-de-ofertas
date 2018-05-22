package com.example.daniel.atividadeandroid;

import java.io.Serializable;

public class Carro implements Serializable {

    private String nome;
    private String descricao;
    private int assetImg;
    private String urlImg;

    public Carro(String nome, String descricao, String urlImg) {
        this.nome = nome;
        this.descricao = descricao;
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

    public int getAssetImg() {
        return assetImg;
    }

    public void setAssetImg(int assetImg) {
        this.assetImg = assetImg;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }
}
