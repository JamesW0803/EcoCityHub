package com.example.ecocity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class UserProfileMain extends AppCompatActivity {
    TextView TitleUsername, UserPoint;
    ConstraintLayout myConstraintLayout, AboutUsConstraint, supportLayout;
    ImageView imageView,imageViewButton;
    Button buttonLogOut;

    private final int GALLERY_REQ_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TitleUsername = findViewById(R.id.UserName);
        UserPoint= findViewById(R.id.textView3);
        showUserData();

        //profile picture
        imageView = findViewById(R.id.imageView);
        imageViewButton = findViewById(R.id.imageView4);
        // setting profile picture
        imageViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent(Intent.ACTION_PICK);
                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(iGallery,GALLERY_REQ_CODE);
            }
        });

        buttonLogOut= findViewById(R.id.button);
        buttonLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                startActivity(new Intent(UserProfileMain.this,User_login.class));
                finish();
            }
        });

        myConstraintLayout = findViewById(R.id.editProfile);
        myConstraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileMain.this, EditProfile.class);
                startActivity(intent);
                passUserData();
            }
        });

        AboutUsConstraint = findViewById(R.id.AboutUsLayout);
        AboutUsConstraint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileMain.this, AboutUs.class);
                startActivity(intent);
            }
        });

        supportLayout= findViewById(R.id.SupportLayout);
        supportLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfileMain.this, ReportProb.class);
                startActivity(intent);
            }
        });
    }


    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK) {
            if (requestCode == GALLERY_REQ_CODE) {
                // for gallery
                imageView.setImageURI(data.getData());
            }
        }
    }

    // retrieve data from firebase and display at user profile
    public void showUserData(){
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("username");

        TitleUsername.setText(nameUser);
    }


    // To pass data to edit profile
    public void passUserData(){
        String userUsername = TitleUsername.getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Users");
        Query checkUsersDatabase = reference.orderByChild("username").equalTo(userUsername);

        checkUsersDatabase.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.exists()){
                    String usernameFromBB = snapshot.child(userUsername).child("username").getValue(String.class);
                    String genderFromBB = snapshot.child(userUsername).child("gender").getValue(String.class);
                    String contNumFromBB = snapshot.child(userUsername).child("contNum").getValue(String.class);
                    String emailFromBB = snapshot.child(userUsername).child("email").getValue(String.class);
                    String addressFromBB = snapshot.child(userUsername).child("address").getValue(String.class);
                    String passFromBB = snapshot.child(userUsername).child("pass1").getValue(String.class);
                    String dateFromDB = snapshot.child(userUsername).child("date").getValue(String.class);

                    Intent intent = new Intent(UserProfileMain.this, EditProfile.class);
                    intent.putExtra("username", usernameFromBB);
                    intent.putExtra("gender", genderFromBB);
                    intent.putExtra("contNum", contNumFromBB);
                    intent.putExtra("email", emailFromBB);
                    intent.putExtra("address", addressFromBB);
                    intent.putExtra("password", passFromBB);
                    intent.putExtra("date",dateFromDB);

                    startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}