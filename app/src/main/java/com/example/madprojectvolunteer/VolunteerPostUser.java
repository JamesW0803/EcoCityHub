package com.example.madprojectvolunteer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class VolunteerPostUser extends AppCompatActivity {
    MaterialButton BtnVolPostBack, BTEditActivity;
    TextView TVVolPostTitle, TVVolPostDesc, TVVolPostPoints, TVVolPostDate, TVVolPostTime, TVVolPostLocation, TVVolPostAddress, TVAgeGroupValue, TVRequirementsValue, TVContactValue;
    AppCompatButton BtnVolApply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_post_user);
        BtnVolPostBack = findViewById(R.id.BtnVolPostBack);
        TVVolPostTitle = findViewById(R.id.TVVolPostTitle);
        TVVolPostDesc = findViewById(R.id.TVVolPostDesc);
        TVVolPostPoints = findViewById(R.id.TVVolPostPoints);
        TVVolPostDate = findViewById(R.id.TVVolPostDate);
        TVVolPostTime = findViewById(R.id.TVVolPostTime);
        TVVolPostLocation = findViewById(R.id.TVVolPostLocation);
        TVVolPostAddress = findViewById(R.id.TVVolPostAddress);
        TVAgeGroupValue = findViewById(R.id.TVAgeGroupValue);
        TVRequirementsValue = findViewById(R.id.TVRequirementsValue);
        TVContactValue = findViewById(R.id.TVContactValue);
        BtnVolApply = findViewById(R.id.BtnVolApply);

        String organizerName = getIntent().getStringExtra(VolunteerList.ORGANIZER_NAME);
        String activityKey = getIntent().getStringExtra(VolunteerList.ACTIVITY_KEY);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Activities").child(organizerName).child(activityKey);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                VolunteerPostUserHelper volPostHelper = snapshot.getValue(VolunteerPostUserHelper.class);

                if (volPostHelper != null){
                    TVVolPostTitle.setText(volPostHelper.getTitle());
                    TVVolPostDesc.setText(volPostHelper.getDescription());
                    TVVolPostPoints.setText(volPostHelper.getPoints() + " Points");
                    TVVolPostDate.setText(volPostHelper.getDateActivity());
                    TVVolPostTime.setText(volPostHelper.getStartTimeActivity() + " - " + volPostHelper.getEndTimeActivity());
                    TVVolPostLocation.setText(volPostHelper.getLocation());
                    TVVolPostAddress.setText(volPostHelper.getAddress());
                    TVAgeGroupValue.setText(volPostHelper.getMinimumAge() + " - " + volPostHelper.getMaximumAge() + " years old");
                    TVRequirementsValue.setText(volPostHelper.getRequirements());
                    TVContactValue.setText(volPostHelper.getContactNo());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(VolunteerPostUser.this, "Failed to load activity details.", Toast.LENGTH_SHORT).show();
            }
        });

        BtnVolPostBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolunteerPostUser.this, VolunteerList.class);
                startActivity(intent);
            }
        });

        BtnVolApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(VolunteerPostUser.this, UploadCV.class);
                startActivity(intent);
            }
        });
    }
}
