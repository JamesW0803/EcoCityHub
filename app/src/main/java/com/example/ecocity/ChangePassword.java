package com.example.ecocity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ChangePassword extends AppCompatActivity {
    String username;
    TextView textView24;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        textView24= findViewById(R.id.textView24);
        showData();
    }

    public void showData(){
        Intent intent = getIntent();

        username = intent.getStringExtra("username");
        textView24.setText(username);


    }
}