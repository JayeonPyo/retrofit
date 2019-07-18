package com.example.appplepie.utils;

import com.example.appplepie.model.MultipleArticles;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitInterface {

    @GET("/api/articles")
    Call<MultipleArticles> getAriticles();



}
