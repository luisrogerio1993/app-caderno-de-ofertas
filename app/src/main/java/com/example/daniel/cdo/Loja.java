package com.example.daniel.cdo;

import com.google.gson.annotations.SerializedName;

public class Loja {

    @SerializedName("id")
    private int idLoja;

    @SerializedName("image")
    private String urlImage;

    @SerializedName("nome")
    private String nome;

    @SerializedName("rua")
    private String rua;

    @SerializedName("numero")
    private String numeroRua;

    @SerializedName("bairro")
    private String bairro;

    @SerializedName("ddd_telefone_fixo")
    private String dddTelefoneFixo;

    @SerializedName("telefone_fixo")
    private String telefoneFixo;

    @SerializedName("ddd_telefone_celular")
    private String dddTelefoneCelular;

    @SerializedName("telefone_celular")
    private String telefoneCelular;

    public Loja() {}

    public Loja(int idLoja, String urlImage, String nome, String rua, String numeroRua, String bairro, String dddTelefoneFixo, String telefoneFixo, String dddTelefoneCelular, String telefoneCelular) {
        this.idLoja = idLoja;
        this.urlImage = urlImage;
        this.nome = nome;
        this.rua = rua;
        this.numeroRua = numeroRua;
        this.bairro = bairro;
        this.dddTelefoneFixo = dddTelefoneFixo;
        this.telefoneFixo = telefoneFixo;
        this.dddTelefoneCelular = dddTelefoneCelular;
        this.telefoneCelular = telefoneCelular;
    }

    public int getIdLoja() {
        return idLoja;
    }

    public void setIdLoja(int idLoja) {
        this.idLoja = idLoja;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroRua() {
        return numeroRua;
    }

    public void setNumeroRua(String numeroRua) {
        this.numeroRua = numeroRua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getDddTelefoneFixo() {
        return dddTelefoneFixo;
    }

    public void setDddTelefoneFixo(String dddTelefoneFixo) {
        this.dddTelefoneFixo = dddTelefoneFixo;
    }

    public String getTelefoneFixo() {
        return telefoneFixo;
    }

    public void setTelefoneFixo(String telefoneFixo) {
        this.telefoneFixo = telefoneFixo;
    }

    public String getDddTelefoneCelular() {
        return dddTelefoneCelular;
    }

    public void setDddTelefoneCelular(String dddTelefoneCelular) {
        this.dddTelefoneCelular = dddTelefoneCelular;
    }

    public String getTelefoneCelular() {
        return telefoneCelular;
    }

    public void setTelefoneCelular(String telefoneCelular) {
        this.telefoneCelular = telefoneCelular;
    }
}
