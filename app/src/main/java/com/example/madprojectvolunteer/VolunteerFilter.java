package com.example.madprojectvolunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class VolunteerFilter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_filter);

        // Back Button
        ImageButton btnFilterBack = findViewById(R.id.BtnFilterBack);
        btnFilterBack.setOnClickListener(v -> {
            //startActivity(new Intent(this, VolunteerList.class));
            finish();
        });

    }
}
