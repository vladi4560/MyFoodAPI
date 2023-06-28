package com.example.foodapi;

import com.google.gson.annotations.SerializedName;

public class FoodDetail {
    @SerializedName("Food")
    private String name;
    @SerializedName("Calories")
    private int calories;


    public FoodDetail() {

    }
    public FoodDetail(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    @Override
    public String toString() {
        return "FoodDetail{" +
                "name='" + name + '\'' +
                ", calories=" + calories +
                '}';
    }
}
