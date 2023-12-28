package com.example.rewardsandpointssystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class leaderboardAdapter extends RecyclerView.Adapter<leaderboardAdapter.ActivityViewHolder> {

    private List<leaderboardHelper> rankings;
    private View.OnClickListener clickListener;

    public leaderboardAdapter (ArrayList <leaderboardHelper> rankings, OnItemClickListener clickListener){
        this.rankings = rankings;
        this.clickListener = view -> clickListener.onClick((String) view.getTag());
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder (@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.leaderboard_card, parent, false);
        ActivityViewHolder viewHolder = new ActivityViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        leaderboardHelper model = rankings.get(position);
        holder.username.setText(model.getUsername());
        holder.points.setText(model.getPoints());
        holder.ranking.setText(model.getRanking());
    }

    public int getItemCount(){
        return rankings.size();
    }

    public class ActivityViewHolder extends RecyclerView.ViewHolder{
        TextView username, points, ranking;

        public ActivityViewHolder(View itemView){
            super(itemView);

            username = itemView.findViewById(R.id.username);
            points = itemView.findViewById(R.id.points);
            ranking = itemView.findViewById(R.id.ranking);
        }

    }


    public interface OnItemClickListener{
        void onClick(String key);

        void onItemClick(String key);
    }
}
