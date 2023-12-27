package com.example.ecocityhub;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button TestProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

//        TestProfile = findViewById(R.id.TestProfile);
//
//        TestProfile.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, Profile_lyaa.class);
//                startActivity(intent);
//            }
//        });
        setContentView(R.layout.activity_profile_lyaa_page8);
//        setContentView(R.layout.activity_change_page56);
//          setContentView(R.layout.activity_upload_option_page4);
//        setContentView(R.layout.chat);
//        setContentView(R.layout.item_description);
        //setContentView(R.layout.activity_main_page1);
    }
}