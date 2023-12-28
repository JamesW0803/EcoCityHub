package com.example.rewardsandpointssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class Guideline1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guideline1);

        ImageButton backButton2 = findViewById(R.id.backButton2);
        backButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(Guideline1.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}