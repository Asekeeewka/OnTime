package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class RestoranActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restoran);

        ArrayList<RestoranItem> restoranList = new ArrayList<>();
        restoranList.add(new RestoranItem(R.drawable.bg5,"Aroma","400,00","1.5"));
        restoranList.add(new RestoranItem(R.drawable.bg3,"CoffeeBOOM","400,00","1.7"));
        restoranList.add(new RestoranItem(R.drawable.bg6,"Thali","400,00","2.5"));
        restoranList.add(new RestoranItem(R.drawable.bg2,"VeganGo","400,00","3.0"));

        mRecyclerView = findViewById(R.id.restoran_recycler);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new RestoranAdapter(restoranList);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onBackPressed()
    {
        // code here to show dialog

    }
}
