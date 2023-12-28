package com.example.rewardsandpointssystem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Leaderboard extends AppCompatActivity {

    private ArrayList<leaderboardHelper> rankingsList;
    private RecyclerView usersView;
    private leaderboardAdapter rankingAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);

        // Initialize Firebase
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = firebaseDatabase.getReference().child("your_database_node"); // Change to your actual node

        // Initialize RecyclerView and Adapter
        usersView = findViewById(R.id.recyclerView);
        usersView.setHasFixedSize(true);
        usersView.setLayoutManager(new LinearLayoutManager(this));

        rankingsList = new ArrayList<>();
        // Add sample data (replace this with data from Firebase)
        rankingsList.add(new leaderboardHelper("User1", 100, "1"));
        rankingsList.add(new leaderboardHelper("User2", 90, "2"));

        rankingAdapter = new leaderboardAdapter(rankingsList, new leaderboardAdapter.OnItemClickListener() {
            @Override
            public void onClick(String key) {

            }

            @Override
            public void onItemClick(String key) {
                // Handle item click, e.g., open profile activity
                Intent intent = new Intent(Leaderboard.this, TestProfile.class);
                intent.putExtra("userKey", key);
                startActivity(intent);
            }
        });

        usersView.setAdapter(rankingAdapter);

        // Fetch Data from Firebase
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                rankingsList.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    leaderboardHelper helper = snapshot.getValue(leaderboardHelper.class);
                    if (helper != null) {
                        rankingsList.add(helper);
                    }
                }
                rankingAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Handle error
            }
        });

        // Back Button Click Listener
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Leaderboard.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
