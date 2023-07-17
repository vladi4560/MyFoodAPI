package com.example.myfoodapi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private MaterialButton openBmi,openCal,openDiet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_activity);
        findViews();

    }


    private void findViews() {
        openBmi = findViewById(R.id.menu_Btn_Bmi);
        openCal = findViewById(R.id.menu_Btn_Cal);
        openDiet  = findViewById(R.id.menu_Btn_Diet);

        openBmi.setOnClickListener(view-> action(1));
        openCal.setOnClickListener(view-> action(2));
        openDiet.setOnClickListener(view-> action(3));
    }

    private void action(int page) {

        // Handle button clicks
        switch (page) {
            case 1:
                openActivity(BmiActivity.class);
                break;
            case 2:
                openActivity(CaloriesActivity.class);
                break;
            case 3:
                openActivity(BmiActivity.class);
                break;
        }
    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}
