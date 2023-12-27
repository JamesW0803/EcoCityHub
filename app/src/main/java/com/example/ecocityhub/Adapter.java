package com.example.ecocityhub;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Item> dataList;
    private Context context;
    LayoutInflater inflater;

    public Adapter(Context context, List<Item> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_item_list, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(view);
        return viewHolder;
//        View view;
//        LayoutInflater mInflater = LayoutInflater.from(context);
//        view = mInflater.inflate(R.layout.cardview_item_list, parent, false);
//        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Item data = dataList.get(position);

        holder.imageViewItem.setImageResource(data.getImageItem());
        holder.imageViewProfile.setImageResource(data.getImageProfile());
        holder.imageViewFavourite.setImageResource(data.getImageFavourite());
        holder.textViewUsername.setText(data.getUsername());
        holder.textViewItemDescription.setText(data.getItemDescription());
        holder.textViewType.setText(data.getType());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewItem;
        ImageView imageViewProfile;
        ImageView imageViewFavourite;
        TextView textViewUsername;
        TextView textViewItemDescription;
        TextView textViewType;

        public MyViewHolder(View itemView) {
            super(itemView);

            imageViewItem = itemView.findViewById(R.id.item_id);
            imageViewProfile = itemView.findViewById(R.id.profile_picture_id);
            imageViewFavourite = itemView.findViewById(R.id.favourite_id);
            textViewUsername = itemView.findViewById(R.id.username_id);
            textViewItemDescription = itemView.findViewById(R.id.item_description_id);
            textViewType = itemView.findViewById(R.id.type_id);
        }
    }
}
