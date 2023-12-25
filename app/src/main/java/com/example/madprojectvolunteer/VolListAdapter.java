package com.example.madprojectvolunteer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class VolListAdapter extends RecyclerView.Adapter<VolListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<VolListData> dataArrayList;

    public VolListAdapter(Context context, ArrayList<VolListData> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_volunteer_card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VolListData volListData = dataArrayList.get(position);

        holder.volTitle.setText(volListData.title);
        holder.volLocation.setText(volListData.location);
        holder.volDate.setText(volListData.date.toString()); // Convert LocalDate to String as needed
        holder.volTime.setText(volListData.time.toString()); // Convert LocalTime to String as needed

        // Check the condition for isFav and set the image resource accordingly
        if (volListData.isFav) {
            holder.heartImageView.setImageResource(R.drawable.heart_filled); // Use the resource id for heart_filled image
        } else {
            holder.heartImageView.setImageResource(R.drawable.heart_empty); // Use the resource id for heart_empty image
        }
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView volTitle, volLocation, volDate, volTime;
        ImageView heartImageView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            volTitle = itemView.findViewById(R.id.TVVolListTitle);
            volLocation = itemView.findViewById(R.id.TVVolListLocation);
            volDate = itemView.findViewById(R.id.TVVolListDate);
            volTime = itemView.findViewById(R.id.TVVolListTime);
            heartImageView = itemView.findViewById(R.id.IVHeart);
        }
    }
}
