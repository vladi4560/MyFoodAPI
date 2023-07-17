package com.example.myfoodapi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapi.FoodManager;

import java.text.DecimalFormat;

public class BmiActivity extends AppCompatActivity {

    private SeekBar heightSeekBar;
    private SeekBar weightSeekBar;
    private SeekBar ageSeekBar;
    private TextView heightMin, weightMin, ageMin;
    private TextView heightMax, weightMax, ageMax,bmiAnswer,bmiSugg;
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
                double bmi;
               if(valueOfAge!=0  && valueOfAge!=0 && valueOfAge!=0){
                   bmi = FoodManager.getInstance().getBMI((double) valueOfHeight,(double)valueOfWeight,valueOfAge);
                   DecimalFormat decimalFormat = new DecimalFormat("#");
                   String formattedValue = decimalFormat.format(bmi);
                   bmiAnswer.setText(formattedValue);
                   bmiSugg.setText(FoodManager.getInstance().getWeightString());
               }

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
        bmiAnswer = findViewById(R.id.Bmi_answer);
        bmiSugg = findViewById(R.id.Bmi_suggestion);
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
