package com.example.madprojectvolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the button by its ID
        Button volunteerButton = findViewById(R.id.BtnVolunteer);

        // Set an OnClickListener for the button
        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click, navigate to Volunteer List page
                try {
                    Intent intent = new Intent(MainActivity.this, VolunteerList.class);
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });

    }
}
