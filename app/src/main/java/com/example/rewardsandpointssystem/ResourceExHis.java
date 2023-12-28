package com.example.rewardsandpointssystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ResourceExHis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resource_ex_his);

        ImageButton backButton4 = findViewById(R.id.backButton4);
        backButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start the NewPageActivity when the button is clicked
                Intent intent = new Intent(ResourceExHis.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}