package com.example.rewardsandpointssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Volunteerism_History extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteerism_history);

        ImageButton backButton3 = findViewById(R.id.backButton3);
        backButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(Volunteerism_History.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}