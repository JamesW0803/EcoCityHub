package com.example.ecocity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class Rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        RatingBar RateBarProfile = findViewById(R.id.ratingBar);
        RatingBar RateBarVolunteer = findViewById(R.id.ratingBar2);
        RatingBar RateBarResource = findViewById(R.id.ratingBar3);
        RatingBar RateBarPoint = findViewById(R.id.ratingBar4);
        RatingBar RateBarOverall = findViewById(R.id.ratingBar5);

        LayerDrawable stars = (LayerDrawable) RateBarProfile.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(Color.parseColor("#966fd6"), PorterDuff.Mode.SRC_ATOP);


        Button button = findViewById(R.id.buttonSubmit);

        TextView OverallRateCount = findViewById(R.id.textViewOverall);
        TextView ProfileRateCount = findViewById(R.id.textViewProfile);
        TextView ResourceRateCount = findViewById(R.id.textViewResource);
        TextView VolunteerRateCount = findViewById(R.id.textViewVolunteer);
        TextView PointRateCount = findViewById(R.id.textViewPoint);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = "We appreciated you rating! It means a lot to us.";
                Toast.makeText(getApplicationContext(),message,Toast.LENGTH_LONG).show();

                Intent intent = new Intent(Rating.this, UserProfileMain.class);
                startActivity(intent);


            }
        });

        RateBarProfile.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ProfileRateCount.setText("You have rated " + rating);
            }
        });

        RateBarVolunteer.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                VolunteerRateCount.setText("You have rated " + rating);
            }
        });

        RateBarPoint.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                PointRateCount.setText("You have rated " + rating);
            }
        });

        RateBarOverall.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                OverallRateCount.setText("You have rated " + rating);
            }
        });

        RateBarResource.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                ResourceRateCount.setText("You have rated " + rating);
            }
        });
    }
}