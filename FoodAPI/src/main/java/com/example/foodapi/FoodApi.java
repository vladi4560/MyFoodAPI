package com.example.foodapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {

    public static final String BASE_URL = "https://script.google.com/macros/s/AKfycbzoBV_kop-iUl1CEE34HR2uBbOrFRcf6YeP0rBBlPyXQE1iMEfgx4xkCUsGeq9hwLa1/";

    @GET("exec")
    Call<List<FoodDetail>> getFoodDetails(@Query("action") String getFood);

    @GET("exec?action=getFood")
    Call<List<FoodDetail>> getFoodDetails1();
}
