package com.example.madprojectvolunteer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class VolListAdapter extends ArrayAdapter<VolListData> {

    public VolListAdapter(@NonNull Context context, ArrayList<VolListData> dataArrayList) {
        super(context, R.layout.volunteer_card, dataArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        VolListData volListData = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.volunteer_card, parent, false);
        }

        TextView volTitle = view.findViewById(R.id.TVVolListTitle);
        TextView volLocation = view.findViewById(R.id.TVVolListLocation);
        TextView volDate = view.findViewById(R.id.TVVolListDate);
        TextView volTime = view.findViewById(R.id.TVVolListTime);
        ImageView heartImageView = view.findViewById(R.id.IVHeart);

        volTitle.setText(volListData.title);
        volLocation.setText(volListData.location);
        volDate.setText(volListData.date.toString()); // Convert LocalDate to String as needed
        volTime.setText(volListData.time.toString()); // Convert LocalTime to String as needed

        // Check the condition for isFav and set the image resource accordingly
        if (volListData.isFav) {
            heartImageView.setImageResource(R.drawable.heart_filled); // Use the resource id for heart_filled image
        } else {
            heartImageView.setImageResource(R.drawable.heart_empty); // Use the resource id for heart_empty image
        }

        return view;
    }
}

