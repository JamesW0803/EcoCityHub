package com.example.madprojectvolunteer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;


public class UserHome extends AppCompatActivity {

    //  Value (of USERNAME) to put in Intent
    public String username; //TODO: Intent Value

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        // Volunteer Button
        Button volunteerButton = findViewById(R.id.BtnHomeVolunteer);

            //Get username
            username = getIntent().getStringExtra("username");

//            Toast.makeText(UserHome.this, username, Toast.LENGTH_LONG).show(); //TODO: Toast: Testing Username

        volunteerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click, navigate to Volunteer List page
                try {
                    Intent intent = new Intent(UserHome.this, VolunteerList.class);
                    intent.putExtra("username",username); // TODO: Must put this to pass username
                    startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });


        // Log Out Button

        Button buttonLogOut= findViewById(R.id.UserHomeLogOut);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserHome.this, User_login.class));
                finish();
            }
        });


    }
}