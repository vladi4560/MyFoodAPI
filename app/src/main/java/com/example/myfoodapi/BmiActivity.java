package com.example.myfoodapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapi.FoodManager;

public class BmiActivity extends AppCompatActivity {

    private SeekBar heightSeekBar;
    private SeekBar weightSeekBar;
    private SeekBar ageSeekBar;
    private TextView heightMin, weightMin, ageMin;
    private TextView heightMax, weightMax, ageMax;
    private Button getBmiButton;

    private int valueOfAge, valueOfHeight, valueOfWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bmi_activity);

        findViews();
        valueOfAge = 0;
        valueOfHeight = 0;
        valueOfWeight = 0;

        getBmiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int height = heightSeekBar.getProgress();
                int weight = weightSeekBar.getProgress();
                int age = ageSeekBar.getProgress();

                // Perform some action with the height, weight, and age values

            }
        });
    }

    private double calculateBMI(int height, int weight, int age) {
        double heightInMeters = height / 100.0;
        double bmi = weight / (heightInMeters * heightInMeters);
        return bmi;
    }

    private void findViews() {
        heightSeekBar = findViewById(R.id.heightSeekBar);
        weightSeekBar = findViewById(R.id.weightSeekBar);
        ageSeekBar = findViewById(R.id.AgeSeekBar);
        heightMin = findViewById(R.id.height_min);
        weightMin = findViewById(R.id.weight_min);
        ageMin = findViewById(R.id.Age_min);
        heightMax = findViewById(R.id.height_max);
        weightMax = findViewById(R.id.weight_max);
        ageMax = findViewById(R.id.Age_max);
        getBmiButton = findViewById(R.id.buttonGetBMI);

        setListener();
    }

    private void setListener() {

        heightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = String.valueOf(progress);
                heightMin.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueOfHeight = seekBar.getProgress();
            }
        });

        weightSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = String.valueOf(progress);
                weightMin.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueOfWeight = seekBar.getProgress();
            }
        });

        ageSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String str = String.valueOf(progress);
                ageMin.setText(str);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                valueOfAge = seekBar.getProgress();
            }
        });
    }
}
