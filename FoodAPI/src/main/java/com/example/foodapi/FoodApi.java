package com.example.foodapi;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface FoodApi {

    public static final String BASE_URL = "https://script.google.com/macros/s/AKfycbxJ3RkOsgZMglqy3WFyoMPfpak_fJq0W9IDB636N8xFMVeklhszh5CKYNIh4SDyrUKx/";

    @GET("exec?action=meal")
    Call<List<FoodDetail>> getFoodDetail(@Query("name") String getFood);
//@Query("name") String getFood
    @GET("exec?action=getFood")
    Call<List<FoodDetail>> getFoodDetails();
}
