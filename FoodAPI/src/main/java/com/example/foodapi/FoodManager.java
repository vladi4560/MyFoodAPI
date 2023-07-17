package com.example.foodapi;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;

import java.util.List;

public class FoodManager {

    public static FoodManager foodManager;
    private List<FoodDetail> foodDetails;
    private double BMI;

    private int maxConsumed = 0;
    private WeightStatus weightStatus;
    private String weightString;
    private double calories;

    public enum WeightStatus {
        UNDERWEIGHT, HEALTHYWEIGHT, OVERWEIGHT, OBESITY
    }

    public static FoodManager getInstance() {
        if (foodManager == null) {
            foodManager = new FoodManager();
        }
        return foodManager;
    }

    public FoodManager() {
        downloadFood();
    }

    private void downloadFood() {
        new FoodHelper().fetchAllRecipes(new FoodHelper.CallBack_FoodDetails() {
            @Override
            public void getFoodDetails(List<FoodDetail> list) {
                foodDetails = list;
            }
        });
    }

    public double getBMI(double height, double weight, int age) {
        BMI = weight / ((height / 100) * (height / 100));
        checkWeightStatus(BMI);
        if (age > 45)
            return BMI * 0.85;
        return BMI;
    }

    private void checkWeightStatus(double bmi) {
        if (bmi < 18.5) {
            weightStatus = WeightStatus.UNDERWEIGHT;
        } else if (bmi >= 18.5 && bmi <= 24.9) {
            weightStatus = WeightStatus.HEALTHYWEIGHT;
        } else if (bmi > 24.9 && bmi < 30) {
            weightStatus = WeightStatus.OVERWEIGHT;
        } else {
            weightStatus = WeightStatus.OBESITY;
        }
        WeightStatus();
    }

    private void WeightStatus() {
        switch (weightStatus) {
            case UNDERWEIGHT:
                weightString = "You are Underweight and need to start to grab some food";
                break;
            case HEALTHYWEIGHT:
                weightString = "You are in  Healthy weight , you only need to maintain it";
                break;
            case OVERWEIGHT:
                weightString = "You are Overweight , start looking after your nutrition";
                break;
            case OBESITY:
                weightString = "You must start doing sport and eat healthy";
                break;
        }
    }

    public double checkCaloriesPerFood(FoodDetail food, double amountGrams) {
        double sum = amountGrams / 100;
        double calories = food.getCalories()*sum;
        return calories;
    }


    public List<FoodDetail> getFoodList() {
        return foodDetails;
    }

    public void setMaxConsumed(int amount) {
        maxConsumed = amount;
    }

    public String getWeightString() {
        return weightString;
    }

    private FoodDetail food;

    public void getFoodDetail(String foodName, CallBack_getFood callBack_getFood) {
        String lowercase = foodName.toLowerCase();
        String capitalized = lowercase.substring(0, 1).toUpperCase() + lowercase.substring(1);


        new FoodHelper().fetchFood(capitalized, new FoodHelper.CallBack_FoodDetail() {
            @Override
            public void getFoodDetail(FoodDetail foodDetail) {

                food = foodDetail;
                if (callBack_getFood != null)
                    callBack_getFood.getFood(food);
            }
        });


    }

    public interface CallBack_getFood {
        void getFood(FoodDetail foodDetail);
    }

}
