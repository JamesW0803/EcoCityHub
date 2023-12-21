package com.example.madprojectvolunteer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.madprojectvolunteer.VolListAdapter;
import com.example.madprojectvolunteer.VolListData;

import java.util.ArrayList;

public class VolunteerList extends AppCompatActivity {

    private ListView listView;
    private VolListAdapter listAdapter;
    private ArrayList<VolListData> dataArrayList = new ArrayList<>();
    private VolListData volListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volunteer_list);

        // Assuming you have these arrays
        String[] titleList = {"Animal Shelter Volunteer", "Elderly Care Companion", "Title3", "Title4"};
        String[] locationList = {"PAWS Animal Rescue Center, Subang", "Caring Old Folks Home, Petaling Jaya", "Location 3 Lorem Ipsum Lorem Ipsum", "Location 4"};
        String[] dateList = {"3/12/2023", "Date2", "Date3", "Date4"};
        String[] timeList = {"9:00AM", "Time2", "Time3", "Time4"};
        Boolean[] favList = {true, false, true, false};

        for (int i = 0; i < titleList.length; i++) {
            volListData = new VolListData(titleList[i], locationList[i], dateList[i], timeList[i], favList[i]);
            dataArrayList.add(volListData);
        }

        listView = findViewById(R.id.ListViewVolunteer);
        listAdapter = new VolListAdapter(this, dataArrayList);
        listView.setAdapter(listAdapter);

        //TODO: add DetailedActivity.java and fragment_detailed_activity.xml
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
