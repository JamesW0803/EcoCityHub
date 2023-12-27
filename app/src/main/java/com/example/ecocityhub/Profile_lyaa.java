package com.example.ecocityhub;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

public class Profile_lyaa extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_lyaa_page8);

        // Initialize your data
        ArrayList <Item> Listing = new ArrayList<Item>();
        Listing.add(new Item(R.drawable.img_7, R.drawable.img_6, R.drawable.baseline_favorite_border_24, "melstan", "ASICS TIGER CLASSIC CT MAN S.", "Like New"));
        Listing.add(new Item(R.drawable.img_9, R.drawable.img_14, R.drawable.baseline_favorite_border_24, "Lyaa_01", "SOFT WOMAN KHAKI PLAIN SHIRT", "Brand New"));
        Listing.add(new Item(R.drawable.img_8, R.drawable.img_13, R.drawable.baseline_favorite_border_24, "alison", "300 PAGES PLAIN WHITE NOTE..", "Like New"));
        Listing.add(new Item(R.drawable.img_10, R.drawable.img_6, R.drawable.baseline_favorite_border_24, "Beldon_L", "PLAIN WHITE WIRELESS MOUSE", "Lightly Used"));
        Listing.add(new Item(R.drawable.img_11, R.drawable.img_6, R.drawable.baseline_favorite_border_24, "User_76", "COMFORTABLE SECOND-HAND...", "Moderately Used"));
        Listing.add(new Item(R.drawable.img_12, R.drawable.img_6, R.drawable.baseline_favorite_border_24, "Tracy", "LADIES WOMEN LEATHER HAN..", "Brand New"));

        // Assuming you have a RecyclerView with the id "Listings" in your layout
        RecyclerView myrv = findViewById(R.id.Listings);

        // Initialize your adapter and set it to the RecyclerView
        Adapter adapter = new Adapter(this, Listing);
        myrv.setAdapter(adapter);
    }
}
