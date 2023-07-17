package com.example.foodapi;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FoodHelper {


    static FoodApi recipeApi = null;

    private Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public static FoodApi getFoodApi() {
        if (recipeApi == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(FoodApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            recipeApi = retrofit.create(FoodApi.class);
        }
        return recipeApi;
    }

    List<FoodDetail> foodDetails;

    public void fetchAllRecipes(CallBack_FoodDetails callBack_foodDetails) {
        FoodApi recipeApi1 = getFoodApi();
        Call<List<FoodDetail>> call = recipeApi1.getFoodDetails();
        call.enqueue(new Callback<List<FoodDetail>>() {
            @Override
            public void onResponse(Call<List<FoodDetail>> call, Response<List<FoodDetail>> response) {
                if (response.isSuccessful()) {
                    foodDetails = response.body();
                    //printDetails();
                    if (callBack_foodDetails != null) {
                        callBack_foodDetails.getFoodDetails(foodDetails);
                    }
                } else {
                    System.out.println(response.errorBody());
                    Log.d("pttt", "fail " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<FoodDetail>> call, Throwable t) {

            }


        });
    }
    private List<FoodDetail> f;
    public void fetchFood(String foodName,CallBack_FoodDetail callBack_foodDetail) {
        FoodApi recipeApi1 = getFoodApi();
        Call<List<FoodDetail>> call = recipeApi1.getFoodDetail(foodName);
         ;
        call.enqueue(new Callback<List<FoodDetail>>() {
            @Override
            public void onResponse(Call<List<FoodDetail>> call, Response<List<FoodDetail>> response) {
                if (response.isSuccessful()) {
                    f = response.body();
                    Log.d("pttt", "fail " + f.isEmpty());
                    if (callBack_foodDetail != null && !f.isEmpty() ) {
                        callBack_foodDetail.getFoodDetail(f.get(0));
                    }
                } else {
                    System.out.println(response.errorBody());
                    Log.d("pttt", "fail " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(Call<List<FoodDetail>> call, Throwable t) {

            }
        });


    }

    public interface CallBack_FoodDetails {
        void getFoodDetails(List<FoodDetail> list);
    }
    public interface CallBack_FoodDetail {
        void getFoodDetail(FoodDetail foodDetail);
    }

}
