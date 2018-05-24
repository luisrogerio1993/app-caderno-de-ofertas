package com.example.daniel.cdo.Home;

import com.example.daniel.cdo.Home.AnuncioList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface AnuncioWebService {

    @GET("anuncio/")
    Call<AnuncioList> getAnuncios();
}
