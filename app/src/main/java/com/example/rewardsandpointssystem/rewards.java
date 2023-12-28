package com.example.rewardsandpointssystem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import rewards.Rewards;

import category.Category;
import category.CategoryAdapter;

public class rewards extends AppCompatActivity {

    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rewards);

        rcvCategory = findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        rcvCategory.setLayoutManager(linearLayoutManager);

        categoryAdapter.seetData(getListCategory());
        rcvCategory.setAdapter(categoryAdapter);

    }
    private List<Category> getListCategory() {
        List<Category> listCategory = new ArrayList<>();

        List<Rewards> listRewards = new ArrayList<>();
        listRewards.add(new Rewards(R.drawable.zuscoffee, "Reward 1", "50 points"));
        listRewards.add(new Rewards(R.drawable.jaya_grocer, "Reward 2", "100 points"));
        listRewards.add(new Rewards(R.drawable.watson, "Reward 3", "400 points"));

        listRewards.add(new Rewards(R.drawable.zuscoffee, "Reward 1", "50 points"));
        listRewards.add(new Rewards(R.drawable.jaya_grocer, "Reward 2", "100 points"));
        listRewards.add(new Rewards(R.drawable.watson, "reward 3", "400 points"));

        listCategory.add(new Category("Category 1", listRewards));
        listCategory.add(new Category("Category 2", listRewards));
        listCategory.add(new Category("Category 3", listRewards));
        listCategory.add(new Category("Category 4", listRewards));
        listCategory.add(new Category("Category 5", listRewards));

        return listCategory;
    }
}