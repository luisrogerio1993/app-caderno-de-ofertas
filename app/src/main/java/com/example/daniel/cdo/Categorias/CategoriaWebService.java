package com.example.daniel.cdo.Categorias;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoriaWebService {

    @GET("categorias/")
    Call<CategoriaList> getCategorias();
}
