package com.example.ecocity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        EditText feedbackForm = findViewById(R.id.editTextTextMultiLine);
        Button btnSubmit = findViewById(R.id.button4);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(! feedbackForm.getText().toString().isEmpty()){
                    String message = "We appreciate your feedback, we'll try hard to it!";
                    Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
                }

                Intent intent = new Intent(Feedback.this, UserProfileMain.class);
                startActivity(intent);
            }
        });


    }
}