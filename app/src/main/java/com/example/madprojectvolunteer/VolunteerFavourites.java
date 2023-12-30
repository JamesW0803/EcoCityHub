package com.example.madprojectvolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.ArrayList;

public class VolunteerFavourites extends AppCompatActivity {

    private RecyclerView recyclerView;
    private VolListAdapter recyclerViewAdapter;
    private ArrayList<VolListHelper> dataArrayList = new ArrayList<>();
    private VolListHelper volListHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_favourites);

        //Popup menu

        findViewById(R.id.BtnOptMenuFavourites).setOnClickListener(v -> {
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
                    return true;
                } else {
                    return false;
                }
            });

            popup.show();
        });

        // Back Button
        ImageButton btnFavBack = findViewById(R.id.BtnFavBack);
        btnFavBack.setOnClickListener(v -> {
            startActivity(new Intent(this, UserHome.class));
        });



//        // Assuming you have these arrays
//        String[] titleList = {"Animal Shelter Volunteer", "Elderly Care Companion", "Title3"};
//        String[] locationList = {"PAWS Animal Rescue Center, Subang", "Caring Old Folks Home, Petaling Jaya", "Location3"};
//        String[] dateList = {"3/12/2023", "Date2", "Date3"};
//        String[] timeList = {"9:00AM", "Time2", "Time3"};
//        Boolean[] favList = {true, true, true};
//
//        for (int i = 0; i < titleList.length; i++) {
//            volListData = new VolListData(titleList[i], locationList[i], dateList[i], timeList[i], favList[i]);
//            dataArrayList.add(volListData);
//        }

//        recyclerView  = findViewById(R.id.RecycleViewVolFavourites);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        recyclerViewAdapter  = new VolListAdapter(this, dataArrayList);
//        recyclerView.setAdapter(recyclerViewAdapter);

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
//                Intent intent = new Intent(VolunteerList.this, DetailedActivity.class);
//                intent.putExtra("title", dataArrayList.get(position).title);
//                intent.putExtra("time", dataArrayList.get(position).time); // Assuming time is a string
//                intent.putExtra("location", dataArrayList.get(position).location);
//                // Set the image resource based on the condition
//                if (dataArrayList.get(position).isFav) {
//                    intent.putExtra("image", R.drawable.heart_filled);
//                } else {
//                    intent.putExtra("image", R.drawable.heart_empty);
//                }
//                startActivity(intent);
//            }
//        });
    }
}
