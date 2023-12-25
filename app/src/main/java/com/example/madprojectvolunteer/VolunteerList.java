package com.example.madprojectvolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class VolunteerList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VolListAdapter recyclerViewAdapter;
    private ArrayList<VolListData> dataArrayList = new ArrayList<>();
    private VolListData volListData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_list);

        //Popup menu

        findViewById(R.id.BtnOptMenuVolunteer).setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(this, v);
            popup.getMenuInflater().inflate(R.menu.volunteer_popup_menu, popup.getMenu());

            // Set the click listener for the items inside the PopupMenu
            popup.setOnMenuItemClickListener(item -> {
                // Switching on the item id of the menu item
                int itemId = item.getItemId();
                if (itemId == R.id.menu_vol_list) {
                    // Handle "Volunteer Activities" click
                    startActivity(new Intent(this, VolunteerList.class));
                    return true;
                } else if (itemId == R.id.menu_vol_favourites) {
                    // Handle "Favourites" click
                    startActivity(new Intent(this, VolunteerFavourites.class));
                    return true;
                } else {
                    return false;
                }
            });

            popup.show();
        });

        // Back Button
        ImageButton btnVolBack = findViewById(R.id.BtnVolBack);
        btnVolBack.setOnClickListener(v -> {
            startActivity(new Intent(this, MainActivity.class));
        });

        // Filter Button
        ImageButton btnFilter = findViewById(R.id.BtnVolFilter);
        btnFilter.setOnClickListener(v -> {
            startActivity(new Intent(this, VolunteerFilter.class));
        });

        // RecyclerView setup
        recyclerView = findViewById(R.id.RecycleViewVolunteer);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new VolListAdapter(this, dataArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);

        // Fetch activity data from Firebase
        fetchActivityDataFromFirebase();

    }

    private void fetchActivityDataFromFirebase() {


        // TODO:Incomplete =======================================================

        // Clear the existing data
        dataArrayList.clear();

        // Reference to the user's activities in the Firebase Realtime Database
        DatabaseReference userActivitiesRef = FirebaseDatabase.getInstance().getReference("Activities");

        // Add a ValueEventListener to listen for changes in the data at this location
        userActivitiesRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Iterate through the children (activities) of the user's node
                for (DataSnapshot activitySnapshot : dataSnapshot.getChildren()) {
                    // Deserialize the data into a VolListData object
                    VolListData activity = activitySnapshot.getValue(VolListData.class);

                    // Check if the deserialization was successful
                    if (activity != null) {
                        dataArrayList.add(activity);
                    }
                }

                // Notify the adapter that the dataset has changed
                recyclerViewAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                // Handle errors
                Toast.makeText(VolunteerList.this, "Failed to load activities.", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
