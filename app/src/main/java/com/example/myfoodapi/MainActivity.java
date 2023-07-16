package com.example.myfoodapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodapi.FoodDetail;
import com.example.foodapi.FoodManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<FoodDetail> foodList;
    private ProgressBar progressBar;
    private EditText enterFood;
    private EditText enterAmount;
    private Button addButton ;
    private TextView consumedTextView;
    private double caloriesConsumed;
    private FoodManager foodManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Log.d("pttt", foodList.toString());
        progressBar = findViewById(R.id.progressBar);
        progressBar.setProgress(0);
        enterFood = findViewById(R.id.foodInput);
        enterAmount = findViewById(R.id.amount);
        addButton = findViewById(R.id.AddButton);
        consumedTextView = findViewById(R.id.ConsumedID);

         foodManager = new FoodManager();
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 foodList = foodManager.getFoodList();
                // Get the entered food name
                String foodName = getFoodNameInput(enterFood);
                // Get the entered amount
                int amount = Integer.parseInt(enterAmount.getText().toString());

                // Check if the food name is valid
                if (foodName != null) {
                    // Get the calories for the food
                    double calories = foodManager.checkCaloriesPerFood(foodName,amount);

                    if (calories != -1) {
                        // Calculate the calories consumed

                        caloriesConsumed +=calories;
                        Log.d("pttt",caloriesConsumed + " "+ calories);
                        // Update the progress bar with the consumed calories
                        progressBar.setProgress((int) caloriesConsumed);

                        // Display the consumed calories in the "Consumed:" TextView

                        consumedTextView.setText("Consumed: " + caloriesConsumed);

                        // Clear the input fields
                        enterFood.setText("");
                        enterAmount.setText("");
                    } else {
                        // Food not found in the API
                        Toast.makeText(MainActivity.this, "Food not found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Invalid food name entered
                    Toast.makeText(MainActivity.this, "Invalid food name", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    public String getFoodNameInput(EditText inputStr) {

        String res = inputStr.getText().toString();
        boolean checkStr = checkString(res);
        if (!checkStr) {
            res = null;
        }

        return res;
    }

    public boolean checkString(String res) {



        for (int i =0 ; i< foodList.size(); i++){
            if(foodList.get(i).getName().toLowerCase().equals(res)){
                return true;
            }
        }
        return false;
//        boolean check = foodList.contains(res);
//
//        if (check) {
//           return check;
//        } else {
//            return check;
//        }
    }
}