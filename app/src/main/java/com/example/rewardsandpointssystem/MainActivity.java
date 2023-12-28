package com.example.rewardsandpointssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageButton arrowButton = findViewById(R.id.arrowButton);
        arrowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Leaderboard.class);
                startActivity(intent);
            }
        });

        ImageButton Guideline1_btn = findViewById(R.id.Guideline1_btn);
        Guideline1_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Guideline1.class);
                startActivity(intent);
            }
        });

        ImageButton Guideline2_btn = findViewById(R.id.Guideline2_btn);
        Guideline2_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Guideline2.class);
                startActivity(intent);
            }
        });

        ImageButton VolHis_btn = findViewById(R.id.VolHis_btn);
        VolHis_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, Volunteerism_History.class);
                startActivity(intent);
            }
        });

        ImageButton ResHis_btn = findViewById(R.id.ResHis_btn);
        ResHis_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(MainActivity.this, ResourceExHis.class);
                startActivity(intent);
            }
        });
    }
}