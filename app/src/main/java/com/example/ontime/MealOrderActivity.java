package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MealOrderActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView1;
    private MealOrderAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View rootView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal_order);
        ArrayList<RestoranItem> restoranList = new ArrayList<>();
        restoranList.add(new RestoranItem(R.drawable.bg5, "Aroma", "400,00", "1.5"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "CoffeeBOOM", "400,00", "1.7"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "Thali", "400,00", "2.5"));
        restoranList.add(new RestoranItem(R.drawable.bg5, "VeganGo", "400,00", "3.0"));

        mRecyclerView = findViewById(R.id.fast_food_rv);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView1 = findViewById(R.id.salats_rv);
        mRecyclerView1.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new MealOrderAdapter(restoranList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView1.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView1.setAdapter(mAdapter);
    }
}
