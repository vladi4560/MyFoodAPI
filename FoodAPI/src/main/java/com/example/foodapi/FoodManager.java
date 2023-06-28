package com.example.foodapi;

import android.util.Log;

import java.util.List;

public class FoodManager {

    private List<FoodDetail> foodDetails;
    private List<String> foodList;
    private double BMI;
    private WeightStatus weightStatus;
    private String weightString;
    private double calories;
    public enum WeightStatus{
        UNDERWEIGHT , HEALTHYWEIGHT, OVERWEIGHT, OBESITY
    }
    public FoodManager() {
        downloadFood();
    }

    private void downloadFood() {
        new FoodHelper().fetchAllRecipes(new FoodHelper.CallBack_FoodDetails() {
            @Override
            public void getFoodDetails(List<FoodDetail> list) {
                foodDetails = list;
                printDetails();
            }
        });
    }

    public void getBMI(double height,double weight){
        BMI = weight / (height * height);
        checkWeightStatus(BMI);
    }

    private void checkWeightStatus(double bmi){
        if(bmi<18.5){
            weightStatus = WeightStatus.UNDERWEIGHT;
        } else if (bmi>=18.5 && bmi<=24.9) {
            weightStatus = WeightStatus.HEALTHYWEIGHT;
        } else if (bmi > 24.9 && bmi<30) {
            weightStatus = WeightStatus.OVERWEIGHT;
        }else{
            weightStatus = WeightStatus.OBESITY;
        }
    }

    private void WeightStatus(){
        switch (weightStatus){
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
    private void checkCaloriesPerFood(){

    }
    private void printDetails(){
        for (FoodDetail f: foodDetails) {
            foodList.add(f.getName());
            Log.d("pttt", "food " + f.toString());
        }
    }
}
