package com.example.myfoodapi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.foodapi.FoodManager;

public class Splash_Activity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private ProgressBar progressBar;
    private boolean alreadyDone = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);
        findViews();
        FoodManager.getInstance();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // FirebaseDB firebaseDB=FirebaseDB.getInstance();
                    progressBar.setVisibility(View.INVISIBLE);
                    openActivity(MainActivity.class);


            }
        }, SPLASH_TIME_OUT);

    }

    private void openActivity(Class activity) {
        Intent intent = new Intent(this, activity);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
        finish();
    }

    private void findViews() {
        progressBar = findViewById(R.id.splash_progressBar);
        progressBar.setVisibility(View.VISIBLE);
    }

}
