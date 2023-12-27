package com.example.madprojectvolunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class UploadCV extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upload_cv);

        //Back Button
        ImageButton btnBack = findViewById(R.id.BtnBackUploadCV);
        btnBack.setOnClickListener(v -> {
            finish(); // Close the current activity (UploadCV)
        });

    }
}