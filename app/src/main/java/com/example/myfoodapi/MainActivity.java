package com.example.myfoodapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.foodapi.FoodDetail;
import com.example.foodapi.FoodHelper;
import com.example.foodapi.FoodManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FoodManager m = new FoodManager();
    }

    private void downloadFood() {

        new FoodHelper().fetchAllRecipes(new FoodHelper.CallBack_FoodDetails() {
            @Override
            public void getFoodDetails(List<FoodDetail> list) {

            }
        });
    }
}