package com.example.ontime;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MyOrdersActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private MyOrderAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);
        final ArrayList<MyOrderItem> myOrderList = new ArrayList<>();
        myOrderList.add(new MyOrderItem(R.drawable.bg5,"Aroma","Пицца Пепперони", "Уже в пути","3х"));
        myOrderList.add(new MyOrderItem(R.drawable.bg5,"CoffeeBOOM","Гнездо глухаря", "Обрабатывается","4х"));

        mRecyclerView = findViewById(R.id.my_orders_recycler);
        mAdapter = new MyOrderAdapter(myOrderList);

        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);



    }
}
