package com.example.daniel.cdo.AnuncioPorId;

import com.example.daniel.cdo.Home.AnuncioList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AnuncioPorIdWebService {

    @FormUrlEncoded
    @POST("anuncio/categoria/search")
    Call<AnuncioList> buscaAnuncio(@Field("key-search") int util);
}
